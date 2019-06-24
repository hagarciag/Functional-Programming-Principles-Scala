package week3

//Lecture 3.3: Polimosphism

//A fundamental data structure in many functional languages is the immutable linked list
//It's constructed from teo building blocks
//Nil		the empty list
//Cons	a cell containing an element and the remainder of the list.

//T is the type on which it would function. It is a class of polymosphism because it takes many forms according of the type T.. It is called genercis polymosphism
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
  //Nothing is a subclass of T, so it is compatible with the definition of the trait def head: T. It is called subtyping polymosphism
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  //Nothing is a subclass of List[T], so it is compatible with the definition of the trait tail: List[T]. It is called subtyping polymosphism
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

//Type parameters
//Like classes, functions can have type parameters.
//For instance, here is a function that creates a list consisting of a single element.

//def singleton[](elem: T) = new Cons[T](elem, new Nil[T])

//Type inference
//In fact, Scala compiler can usually deduce the correct type parameters from the value arguments of a function call.
//So, in most cases, type parameters can be left out. You could also write:
//singleton(1)
//singleton(true)

//Types and Evaluation
//Type parameters do not affect evluation in Scala
//We can assume that all type parameters and type arguments are removed before evaluating  the program
//This is call type erasure
//Languages that use type erasure include Java, Scala, Haskell, ML, OCaml.
//Some other languages keep the type parameters around at run time, these include C++, C#, F#

//Polymosphism
//It means that a function type comes "in many forms". In programming it means that
//-	The function can be applied to arguments of many types, or 
//-	The type can have instances of many types.

//We have seen two principal forms of polymorphism:
//-	subtyping: instance of a subclass can be passed to a bse class
//-	generics: instances of a function or class are created by type parametrization

