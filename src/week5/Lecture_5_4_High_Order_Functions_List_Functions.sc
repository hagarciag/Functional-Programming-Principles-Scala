package week5

object Lecture_5_4_High_Order_Functions_List_Functions {
  //A common operation is to transform each element of a list and then return the list of results.
  //For example, to multiply each element of a list by the same factor, you could write:
/*
  def scaleList(xs: List[Double], factor: Double): List[Double] =
    xs match {
      case Nil => xs
      case y :: ys => y * factor :: scaleList(ys, factor)
    }
*/

	//This scheme can be generalized to the method map of the List class.
	//A simple way to define map is as follows:
/*
	//This class does no work because it is the definition of the included class in the core of scala
	abstract class List[T] {
		def map[U](f: T => U): List[U] =
			this match {
				case Nil => this
				case x :: xs => f(x) :: xs.map(f)
			}
	}
*/
  def scaleList(xs: List[Double], factor: Double) =
    xs map (x => x * factor)                      //> scaleList: (xs: List[Double], factor: Double)List[Double]

  def squareList(xs: List[Int]): List[Int] =
    xs map (x => x * x)                           //> squareList: (xs: List[Int])List[Int]

  def posElems(xs: List[Int]): List[Int] =
    xs filter (x => x > 0)                        //> posElems: (xs: List[Int])List[Int]

	val xs: List[Double] = List(1,3,4)        //> xs  : List[Double] = List(1.0, 3.0, 4.0)
	val xs1: List[Int] = List(1,-4,3)         //> xs1  : List[Int] = List(1, -4, 3)
	scaleList(xs, 2)                          //> res0: List[Double] = List(2.0, 6.0, 8.0)
	squareList(xs1)                           //> res1: List[Int] = List(1, 16, 9)
	posElems(xs1)                             //> res2: List[Int] = List(1, 3)
	
	xs1 filter (x => x > 0)                   //> res3: List[Int] = List(1, 3)
	xs1 filterNot (x => x > 0)                //> res4: List[Int] = List(-4)
	xs1 partition (x => x > 0)                //> res5: (List[Int], List[Int]) = (List(1, 3),List(-4))
	
	xs1 takeWhile (x => x > 0)                //> res6: List[Int] = List(1)
	xs1 dropWhile (x => x > 0)                //> res7: List[Int] = List(-4, 3)
	xs1 span (x => x > 0)                     //> res8: (List[Int], List[Int]) = (List(1),List(-4, 3))

	def pack[T](xs: List[T]): List[List[T]]=
		xs match {
			case Nil => Nil
			case x :: xs1 =>
				val (first, second) = xs span (y => y == x)
				first::pack(second)
		}                                 //> pack: [T](xs: List[T])List[List[T]]
		
	pack(List("a","a","a","b","c","c","a"))   //> res9: List[List[String]] = List(List(a, a, a), List(b), List(c, c), List(a)
                                                  //| )
	def encode[T](xs: List[T]): List[(T, Int)]=
		pack(xs) map (ys => (ys.head, ys.length))
                                                  //> encode: [T](xs: List[T])List[(T, Int)]

	encode(List("a","a","a","b","c","c","a")) //> res10: List[(String, Int)] = List((a,3), (b,1), (c,2), (a,1))
}