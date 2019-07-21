package week6

object Lecture_6_2_Handling_Nested_Sequences {
  //We can extend the usage of higher order functions on sequences to many
  //calculations which are usually expressed using nested loops.
  
  //Example: Given a positive integer n, find all pairs of positive integers i and j, with 1 <= j < i < n
  //such that i + j is prime.
  //For example, if n = 7, the sought pairs are:
  // i | 2 3 4 4 5 6 6
  // j | 1 2 1 3 2 1 5
	//-------------------
	//i+j| 3 5 5 7 7 7 11
	
	//A naural way to do this is to:
	//- Generate the sequence of all pairs if integers (i, j) such that
	//	1 <= j < i < n.
	
	//- Filter the pairs for which i + j is prime
	
	//One natural way to generate the sequence of pairs is to:
	//- Generate all integers i between 1 and n (excluded).
	//- For each integer i, generate the list of pairs (i, 1), ..., (i, i-1).

	def isPrime(n: Int) = (2 until n) forall (n % _ != 0)
                                                  //> isPrime: (n: Int)Boolean
	
	val n = 7                                 //> n  : Int = 7
	
	(1 until n) map (i =>
		(1 until i) map (j => (i, j)))    //> res0: scala.collection.immutable.IndexedSeq[scala.collection.immutable.Index
                                                  //| edSeq[(Int, Int)]] = Vector(Vector(), Vector((2,1)), Vector((3,1), (3,2)), V
                                                  //| ector((4,1), (4,2), (4,3)), Vector((5,1), (5,2), (5,3), (5,4)), Vector((6,1)
                                                  //| , (6,2), (6,3), (6,4), (6,5)))
	
	//The previous step gave a sequence of sequecnes, let's call it xss.
	//We can combine all the sub-sequences using foldRight with ++:
	
	//(xss foldRight Seq[]())(_ ++ _)
	
	//Or, equivalently, we use the built-in method flatten
	
	//xss.flatten
	
	//This gives:
	
	((1 until n) map (i =>
		(1 until i) map (j => (i, j)))).flatten
                                                  //> res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,
                                                  //| 1), (3,2), (4,1), (4,2), (4,3), (5,1), (5,2), (5,3), (5,4), (6,1), (6,2), (
                                                  //| 6,3), (6,4), (6,5))
		
	//Here's a useful law:
	
	//xs flatMap f = (xs map f). flatten
	
	//Hence, the above expression can be simplified to
	
	(1 until n) flatMap (i =>
		(1 until i) map (j => (i, j))) filter (pair => isPrime(pair._1 + pair._2)
																									)
                                                  //> res2: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,
                                                  //| 2), (4,1), (4,3), (5,2), (6,1), (6,5))
	//Higher-order functions such as map, flatMap or filter provide powerful
	//constructs for manipulating lists.
	//But sometimes the level of abstraction required by these function make the program difficult to understand
	//In this case, Scala's for expression notation can help
	
	//Let persons be a list of elements of class Person, with fields name and age
	
	case class Person (name: String, age: Int)
	
	//To obtain names of persons over 20 years old, you can write:
	
	//for ( p <- persons if p.age > 20 ) yield p.name
	
	//which is equivalent to:
	
	//persons filter (p => p.age > 20) map (p=>p.name)
	
	//The for-expression is similar to loops in imperative languges, except that it builds a list of results of all iterations
	 
	//A for-expression is if the form:
	//for ( s ) yield e
	//where s is a sequence of generators and filters, and e is an expression whose value is returned by an iteration.
	//- A generator is of the form p <- e, where p is a pattern and e an expression
	//  whose value is a collection.
	//- A filter is of the form if f where f is a boolean expression.
	//- The sequence must start with a generator.
	//- If there are several generators in the sequence, the last generators vary faster than the first.
	
	//Instead of ( s ),	braces { s } can also be used, and then the sequence of
	//generators and filters can be written on multiple lines without requiring semicilons.
	
	//Lets write the same solution given previously on this notation:
	for {
		i <- 1 until n
		j <- 1 until i
		if isPrime(i + j)
	} yield (i, j)                            //> res3: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,
                                                  //| 2), (4,1), (4,3), (5,2), (6,1), (6,5))

	//Lets write a version of the scalar product of the previous session:
	//for( (x, y) <= xs zip ys ) yield x * y ).sum
	
		
	 
}