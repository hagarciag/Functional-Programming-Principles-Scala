package week5

object Lecture_5_5_Reduction_Of_Lists {
  //Another common operation on lists is to combine the lements of a list using a given operator.
  //For exampe:
  
  def sum(xs: List[Int]): Int =
  	xs match {
  		case Nil => 0
  		case y :: ys => y + sum(ys)
  	}                                         //> sum: (xs: List[Int])Int
  	
  //This pattern can be abstracted out using the generic method reduceLeft.
  //reduceLeft inserts a given binaty operator between adjacent elements of a list.
  
  //Usign reduceLEft, we can simplfy:
  def sum1(xs: List[Int]) = (0 :: xs ) reduceLeft((x, y) => x + y)
                                                  //> sum1: (xs: List[Int])Int

	//Instead of ((x, y) => x + y), one can also write shorter:
	//(_ * _)
	//Every _ represents a new parameter, going from left to right.
	
	//The parameters are defined at the next outer pair of parentheses (or the whole expression if there are no enclosing parentheses).
	
	//So, sum and product can also be expressed like this:
	
	def sum2(xs: List[Int]) = (0 :: xs ) reduceLeft(_ + _)
                                                  //> sum2: (xs: List[Int])Int
	//The function reduceLeft is defined in terms of a more general function, foldLeft.
	
	//foldLeft is like reduceLeft but takes un accumulator, z, as an addiotional parameter, which is returned when foldLeft is called on an empty list.
	
	//So, sum can also be defined as follows:
	
	
	def sum3(xs: List[Int]) = (xs foldLeft 0) (_ + _)
                                                  //> sum3: (xs: List[Int])Int
	
	//There are also similar operations to the right: reduceRight y foldRight
	
	
	
}