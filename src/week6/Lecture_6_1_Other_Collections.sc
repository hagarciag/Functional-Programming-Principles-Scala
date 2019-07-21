package week6

object Lecture_6_1_Other_Collections {
	//We have seen that lists are linear. Access to the first elemtn is much faster than access to the middle or end of a list.
	
	//Scala library also defines an alternative sequence implementation, Vector.
	
	//This one has more evenly balanced access patterns than list.
	
  //Vector allows the same operations a lists and is faster than list for bulk operations (map, reduce)
  
  //Vectors are created analogously to lists. They support the same aoperations as lists, with the exception of ::
  //instead of x :: xs, there is:
  //x +: xs Create a new vector with leading element x, followed by all elements of xs
  //xs :+ x Create a new vector with trailing element x, proceded by all elements of xs
  //Note that the : always points to the sequence
  
  //A common base class of List and Vector is Seq, the class of all sequences.
  
  //Seq itsel is a subclass of Iterable.
  
  val nums = Vector(1, 2, 3, -88)                 //> nums  : scala.collection.immutable.Vector[Int] = Vector(1, 2, 3, -88)
  nums map (x => x/2)                             //> res0: scala.collection.immutable.Vector[Int] = Vector(0, 1, 1, -44)
  
  val xs = Array(1, 2, 3, 44)                     //> xs  : Array[Int] = Array(1, 2, 3, 44)
  xs map (x => x * 2)                             //> res1: Array[Int] = Array(2, 4, 6, 88)
  
  val s = "Hello World"                           //> s  : String = Hello World
  s.filter(c => c.isUpper)                        //> res2: String = HW
  
  //Another simple kind of sequence is the range.
  
  
  //												Iterable
  //           Sequence								Set					Map
  // String Array List Vector Range
  //It represents a sequence of evenly spaced integers.
  
  //There operators:
  //to (inclusive), unitl (exclusive), by (to determine step value):
  val r:Range = 1 until 5                         //> r  : Range = Range(1, 2, 3, 4)
  val r2:Range = 1 to 5                           //> r2  : Range = Range(1, 2, 3, 4, 5)
  //1 to 10 by 3
  //6 to 1 by -2
  
  //There are many operations which are common among the iterable:
  s exists (c=> c.isUpper)                        //> res3: Boolean = true
  s forall (c=> c.isUpper)                        //> res4: Boolean = false
	
	val pairs = List(1, 2, 3, 4) zip s        //> pairs  : List[(Int, Char)] = List((1,H), (2,e), (3,l), (4,l))
	pairs.unzip                               //> res5: (List[Int], List[Char]) = (List(1, 2, 3, 4),List(H, e, l, l))
	
	s flatMap (c => List('.', c))             //> res6: String = .H.e.l.l.o. .W.o.r.l.d

	//To list all combinations of numbers x and y
	//where x is drawn from 1..M and y is drawn 1..N
	(1 to 5) flatMap (x => (6 to 10) map (y => (x, y)))
                                                  //> res7: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,6), (1,
                                                  //| 7), (1,8), (1,9), (1,10), (2,6), (2,7), (2,8), (2,9), (2,10), (3,6), (3,7),
                                                  //|  (3,8), (3,9), (3,10), (4,6), (4,7), (4,8), (4,9), (4,10), (5,6), (5,7), (5
                                                  //| ,8), (5,9), (5,10))
	
	//Compute the scalar product of two vectors:
	def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
		(xs zip ys).map(xy => xy._1 * xy._2).sum
                                                  //> scalarProduct: (xs: Vector[Double], ys: Vector[Double])Double
	//An alternative way to write this is with a pattern matching function value
	def scalarProduct1(xs: Vector[Double], ys: Vector[Double]): Double =
		(xs zip ys).map{ case (x, y) => x * y }.sum
                                                  //> scalarProduct1: (xs: Vector[Double], ys: Vector[Double])Double
		
	//Generally, the function value
	//{ case p1 => e1 ... case pn => en }
	
	//is equivalent to
	//x => x match {case p1 => e1 ... case pn => en}
	
	//A number n is prime if the only divisors of n are 1 and n it self.
	//What is a hight-level way to write a test for primality of numbers?
	//For once, value conciseness over efficiency...
	
                                                  
}