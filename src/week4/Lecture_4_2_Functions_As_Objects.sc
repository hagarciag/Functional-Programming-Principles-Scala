package week4
/*
object Lecture_1_2_Functions_As_Objects {
  //An anonymous functuon such as
  (x: Int) => x * x
  //is expanded to
  /*
  {class AnonFun extends Function1[Int, Int]{
  	def apply(x: Int) = x * x
  }
  new AnonFun
  */
  //or, shorter, using anonymous class syntax:
  /*
	new Function1[Int, Int]{
		def apply (x: Int) = x * x
	}
	*/

  //--------------------------------------------------------------
  //A function call, such as f(a, b), where f is a value of some class type, is expanded to
  //f.apply(q, b)

  //So the OO-translation of

  //Val f = (x: Int) => x * x
  //f(7)

  //would be

  /*
	val f = new Function1[Int, Int]{
		def apply(x: Int) = x * x
	}
	f.apply(7)
	*/
}
*/
trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

class Nil[T] extends List[T] {
  def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}
/*
object List {
  // List(1, 2) =List.apply(1, 2)
  def apply[T](x1: T, x2: T): List[T] = new Cons(x1, new Cons(x2, new Nil))
  def apply[T]() = new Nil
}
*/