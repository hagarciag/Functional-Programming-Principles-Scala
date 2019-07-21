

object Lecture3_1_Classes_Hierarchies {
  //new IntSet()   //IntSet is abstract, so it cannot be instatiated
  val a_1_1 = new NonEmpty(4, new Empty, new Empty)
                                                  //> a_1_1  : NonEmpty = {.4.}

  val a_1_2 = a_1_1 incl 1                        //> new NonEmpty(4, [.] incl 1, [.])
                                                  //| new NonEmpty(1, [.], [.])
                                                  //| a_1_2  : IntSet = {{.1.}4.}

  val a_1_3 = a_1_2 incl 7                        //> new NonEmpty(4, [{.1.}], [.] incl 7)
                                                  //| new NonEmpty(7, [.], [.])
                                                  //| a_1_3  : IntSet = {{.1.}4{.7.}}

  val a_2_1 = new NonEmpty(3, new Empty, new Empty)
                                                  //> a_2_1  : NonEmpty = {.3.}

  val a_2_2 = a_2_1 incl 2                        //> new NonEmpty(3, [.] incl 2, [.])
                                                  //| new NonEmpty(2, [.], [.])
                                                  //| a_2_2  : IntSet = {{.2.}3.}

  val a_2_3 = a_2_2 incl 5                        //> new NonEmpty(3, [{.2.}], [.] incl 5)
                                                  //| new NonEmpty(5, [.], [.])
                                                  //| a_2_3  : IntSet = {{.2.}3{.5.}}

  val t6 = a_1_3 union a_2_3                      //> (([{.1.}] union [{.7.}]) union [{{.2.}3{.5.}}]) incl 4
                                                  //| (([.] union [.]) union [{.7.}]) incl 1
                                                  //| [.]
                                                  //| [{.7.}]
                                                  //| new NonEmpty(7, [.] incl 1, [.])
                                                  //| new NonEmpty(1, [.], [.])
                                                  //| (([{.1.}] union [.]) union [{{.2.}3{.5.}}]) incl 7
                                                  //| (([.] union [.]) union [.]) incl 1
                                                  //| [.]
                                                  //| [.]
                                                  //| new NonEmpty(1, [.], [.])
                                                  //| (([.] union [.]) union [{{.2.}3{.5.}}]) incl 1
                                                  //| [.]
                                                  //| [{{.2.}3{.5.}}]
                                                  //| new NonEmpty(3, [{.2.}] incl 1, [{.5.}])
                                                  //| new NonEmpty(2, [.] incl 1, [.])
                                                  //| new NonEmpty(1, [.], [.])
                                                  //| new NonEmpty(3, [{{.1.}2.}], [{.5.}] incl 7)
                                                  //| new NonEmpty(5, [.], [.] incl 7)
                                                  //| new NonEmpty(7, [.], [.])
                                                  //| new NonEmpty(3, [{{.1.}2.}], [{.5{.7.}}] incl 4)
                                                  //| new NonEmpty(5, [.] incl 4, [{.7.}])
                                                  //| new NonEmpty(4, [.], [.])
                                                  //| t6  : IntSet = {{{.1.}2.}3{{.4.}5{.7.}}}




  val t_1 = new NonEmpty(7, new Empty, new Empty) //> t_1  : NonEmpty = {.7.}

  val t0 = new NonEmpty(3, new Empty, new Empty)  //> t0  : NonEmpty = {.3.}

  val t1 = t0 incl 6                              //> new NonEmpty(3, [.], [.] incl 6)
                                                  //| new NonEmpty(6, [.], [.])
                                                  //| t1  : IntSet = {.3{.6.}}

  val t2 = t1 incl 4                              //> new NonEmpty(3, [.], [{.6.}] incl 4)
                                                  //| new NonEmpty(6, [.] incl 4, [.])
                                                  //| new NonEmpty(4, [.], [.])
                                                  //| t2  : IntSet = {.3{{.4.}6.}}

  val t3 = t2 incl 9                              //> new NonEmpty(3, [.], [{{.4.}6.}] incl 9)
                                                  //| new NonEmpty(6, [{.4.}], [.] incl 9)
                                                  //| new NonEmpty(9, [.], [.])
                                                  //| t3  : IntSet = {.3{{.4.}6{.9.}}}

  val t4 = t3 incl 2                              //> new NonEmpty(3, [.] incl 2, [{{.4.}6{.9.}}])
                                                  //| new NonEmpty(2, [.], [.])
                                                  //| t4  : IntSet = {{.2.}3{{.4.}6{.9.}}}

  val t5 = t4 incl 10                             //> new NonEmpty(3, [{.2.}], [{{.4.}6{.9.}}] incl 10)
                                                  //| new NonEmpty(6, [{.4.}], [{.9.}] incl 10)
                                                  //| new NonEmpty(9, [.], [.] incl 10)
                                                  //| new NonEmpty(10, [.], [.])
                                                  //| t5  : IntSet = {{.2.}3{{.4.}6{.9{.10.}}}}


}

abstract class IntSet {
  //IntSet is an abstract class
  //
  //Abstract classes can contain members which are missing an implementation (in our case, inc and contains)
  //
  //Consequently, no instances of an abstract class can be create with the operator new
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

//Let's consider implementing sets as binary trees
//
//There are two possible trees: a tree for the empty set, and a tree consisting of an integer and two sub-trees.
//
//Here are their implementations:

class Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = { println("new NonEmpty(" + x + ", [.], [.])"); new NonEmpty(x, new Empty, new Empty) }
  override def toString = "."
  def union(other: IntSet): IntSet = { println("[" + other + "]"); other }
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean = {
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  }
  def incl(x: Int): IntSet = {
    if (x < elem) {
      println("new NonEmpty(" + elem + ", [" + left + "] incl " + x + ", [" + right + "])")
      new NonEmpty(elem, left incl x, right)
    } else if (x > elem) {
      println("new NonEmpty(" + elem + ", [" + left + "]" + ", [" + right + "] incl " + x + ")"); new NonEmpty(elem, left, right incl x)
    } else { println("This " + this.toString()); this }
  }
  override def toString = "{" + left + elem + right + "}"
  def union(other: IntSet): IntSet = {
    println("(([" + left + "] union [" + right + "]) union [" + other + "]) incl " + elem);
    ((left union right) union other) incl elem
  }
}

//Empty and NonEmpty both extend the class IntSet.
//
//This implies that the types Empty and NonEmpty conform to the type IntSet.
//
//An object of type Empty or NonEmpty can be used wherever an object of type IntSet is required.
//
//IntSet is called the superclass of Empty and NonEmpty.
//
//Empty and NonEmpty are subclasses of IntSet.
//
//In Scala, any user-defined class extends another class.
//
//If no superclass is given, the standard class Object in the Java package java.lang is assumed.
//
//The direct or indirect superclasses of a class C are called base classes of C.
//
//So, the base classes of NonEmpty are IntSet and Object.

//Implementation and overriding
//
// The definition of contains and incl in the classes Empty and NonEmpty implement the abstract functions in the base trait IntSet.
//
//It is also possible to redefine an existing, non-abstract definition in a subclass bu using override.

//Example:

abstract class Base {
  def foo = 1
  def bar: Int
}

class Sub extends Base {
  override def foo = 2
  def bar = 3
}

//Object Definitions
//
//In the IntSet example, one could argue that there is really only a single empty IntSet
//
//So it seems overkill to have the user create many instances of it.
//
//We can express this case better with an object definition
object Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
  override def toString = "."
  def union(other: IntSet): IntSet = other
}
//This defines a singleton object named Empty.
//
//No other Empty instances can be (or need to be) created.
//
//Singleton objects are values, so Empty evaluates to itself.


//Dynamic Binding
//Object-oriented lanuages (including Scala) implement dynamic method dispatch.
//This means that the code invoked by a method call depends on the runtime type of the object that contains the method.
//Example: Empty contains 1