package week1

object Lecture_1_2_Elements_Programming {
  
  //1.5 Example: square roots with Newton's method

  def isGoodEnough(guess: Double, x: Double): Boolean =
    abs(guess * guess - x) / x < 0.001            //> isGoodEnough: (guess: Double, x: Double)Boolean

  def improve(guess: Double, x: Double): Double =
    (guess + x / guess) / 2                       //> improve: (guess: Double, x: Double)Double

  //sqrtIter is recursive because ti calls itself. This type of function needs an explicit return type, for non-recursive the return type is optiona
  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else (sqrtIter(improve(guess, x), x))         //> sqrtIter: (guess: Double, x: Double)Double

  def sqrt(x: Double) = sqrtIter(1.0, x)          //> sqrt: (x: Double)Double

  sqrt(2)                                         //> res6: Double = 1.4142156862745097

}
