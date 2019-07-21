package week5

object Lecture_5_1_More_Functions_On_Lists {
  //List Methods
  //xs.length
  //xs.last
  //xs.init
  //xs take n
  //xs drop n
  //xs(n)
  
  //xs ++ ys
  //xs.reverse
  //xs updated (n,x)
  //xs idenxOf x
  //xs contains x
  
  //Implementation of last
  def last[T](xs: List[T]): T = xs match {
  	case List() => throw new Error("last of empty list")
  	case List(x)=> x
  	case y::ys=>last(ys)
  }                                               //> last: [T](xs: List[T])T
  //So, last takes steps proportinal to the length of the list xs.

  def init[T](xs: List[T]): List[T] = xs match {
  	case List() => throw new Error("last of empty list")
  	case List(x)=> List()
  	case y::ys=>y::init(ys)
  }                                               //> init: [T](xs: List[T])List[T]

	//---contatenation
  def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
  	case List() => ys
  	case List(x)=> List()
  	case z::zs=>z::concat(zs, ys)
  }                                               //> concat: [T](xs: List[T], ys: List[T])List[T]
  // Complexity is the length xs
	
  def reverse[T](xs: List[T]): List[T] = xs match {
  	case List() => List()
  	case y::ys=>reverse(ys) ++ List(y)
  }                                               //> reverse: [T](xs: List[T])List[T]
  //It has a comlexity of M * M
	
}