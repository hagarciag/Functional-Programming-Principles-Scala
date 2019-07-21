package week4

object Lecture_4_3_Subtyping_And_Generics {
	//Two principal forms of polimorfism:
	//- subtyping
	//- generics
	
	//In this session we will look at their interactions
	//Two main areas:
	//- bounds
	//- variance
	
	//-------------UPPER BOUNDS---------------------
	//Consider the method assertAllPos which
	//- takes an IntSet
	//- return the IntSet itself if all its elements are positive
	//- throws an exception otherwise
	
	//What would be the best type you can give to assertAllPoss? Maybe
	//def assertAllPos(s: IntSet): IntSet
	
	//In most situations this is fine, but can one be more precise
	
	//One might wnat to express thet assertAllPos takes Empty sets to Empty sets and NonEmpty sets to NonEmpty sets
	
	//A way to express this is:
	//def assertAllPos[S <: IntSet](r: S): S=...
	//Here, the <: IntSet is an upper bound of the type parameter S:
	//It means that S can be instantiated only to types that conform IntSet
	//Generally, the notation
	//-S <:T means: S is a subtype of T, and
	//-S >:T means: S is a supertype of T, or T is a subtype of S


	//-------------LOWER BOUNDS---------------------
	//[S >: NonEmpty]
	//Introduces a type parameter S that can range only over supertypes of NonEmpty
	//So S could be one of NonEmpty, IntSet, AnyRef, or Any
	
	//It is also possible to mix a lower and a upper bound. For instance,
	//[S >: NonEmpty <: IntSet]
	
	
	//-------------COVARIANCE---------------------
	//There's another  interaction between subtyping and type parameters we need to consider. Given:
	//NonEmpty <: IntSet
	//is
	//List[NonEmpty] <: List[IntSet] ?
	//Intuitively, this makes sense: A list of non-empty sets is a special case of a list of arbitrary sets.
	//We call types for which this relationship holds covariant because their subtyping reationship varies with the type parameter.
	
	//--------------ARRAYS-----------------
	//For perspective, lest's look at arrays in Java (and C#)
	//Reminder:
	//- An array of T elements is written T[]
	//- In scala we use parameterized type syntax Array[T] to refer to the same type
	
	//Arrays in Java are coveriant, so one would have:
	//NonEmpty[] <: IntSet[]
	
	//--------------ARRAY TYPING PROBLEM-----------------
	//But covariant array typing causes problems
	//To see why, consider the Java code below.
	//NONEMPTY[] A = NEW NONEMPTY[]{NEW NONEMPTY(1, EMPTY, EMPTY)}
	//INTSET[] B = A
	//B[0] = EMPTY
	//NonEmpty s = a[0] -> In runtime, it would launch a ArrayStoreException
	
	//It looks like we assigned in the last line an Empty set to a variable of type NonEmpty!
	//What went wrong?
	
	
	//--------------THE LISKOV SUBSTITUTE PRINCIPLE-----------------
	//The following principle, stated by Barbara Liskov, tell us when a type can be a subtype of another.
	//If A<:B, then everything one can to do with a value of type B sould also be able to do with a value of type A

	//In scala the arrays are not covariant
	
	//So, some types should be covariant whereas others sould not.
	//Roughly speaking, a type that accepts mutations of its elements should not be covariant such as the arrays.
	//But immutable types can be covariant, if some conditions on methods are met. Por example, lists

//+T means T is covariant, so T could be filled with any subtype of T
trait List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}
/*
class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}
*/
// The object Nil is a type o List[Nothing]
object Nil extends List[Nothing] {
  def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tal")
}

object test {
	//This is possible because the trait List was declared +T which allows List[Nothing] <: List[String] as Nothing is a subtype of String
	val x: List[String] = Nil
}
	
	
	

	
	
}