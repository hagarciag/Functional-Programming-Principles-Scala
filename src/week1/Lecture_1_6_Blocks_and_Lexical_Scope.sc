package week1

object Lecture_1_4_Elements_Programming {
  
  //1.6 Blocks --------------------------------------------------------------

  def sqrt1(x: Double) = {

    //sqrtIter is recursive because ti calls itself. This type of function needs an explicit return type, for non-recursive the return type is optiona
    def sqrtIter(guess: Double, x: Double): Double =
      if (isGoodEnough(guess, x)) guess
      else (sqrtIter(improve(guess, x), x))

    def isGoodEnough(guess: Double, x: Double): Boolean =
      abs(guess * guess - x) / x < 0.001

    def improve(guess: Double, x: Double): Double =
      (guess + x / guess) / 2

    sqrtIter(1.0, x)

  }                                               //> sqrt1: (x: Double)Double

  //We can eliminate redundant parameter x

  def sqrt2(x: Double) = {

    //sqrtIter is recursive because ti calls itself. This type of function needs an explicit return type, for non-recursive the return type is optiona
    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else (sqrtIter(improve(guess)))

    def isGoodEnough(guess: Double): Boolean =
      abs(guess * guess - x) / x < 0.001

    def improve(guess: Double): Double =
      (guess + x / guess) / 2

    sqrtIter(1.0)

  }                                               //> sqrt2: (x: Double)Double

}
