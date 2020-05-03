package week1


object Lecture_1_4_Elements_Programming {
  
 //1.4--------------------------------------------------------------------
  //Conditional Expressions
  //def abs(x: Int) = if (x >= 0) x else -x
  def abs(x:Double): Double = if (x >= 0) x else -x
                                                  //> abs: (x: Double)Double

  //&& and || do not always need their right operand to be evaluated.

  //Value definitions
  //We have seen that the function parameters can be passed by value or passed by name.
  //The same distinction applies to definitions.
  //The def form is "by-name", its right hand side is evaluated on each use.
  //There is also a val for, which is "by-vale". Example:
  val x = 2                                       //> x  : Int = 2
  //val y = square(x)

  //The right-hand side of a val definition is evaluated at the point of the definitn itself.
  //Afterwards, the name refers to the value.
  //For instance, y above refers to 4, not to square(2)

}