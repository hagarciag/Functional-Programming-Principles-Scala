package week1

object Lecture_1_2_Elements_Programming {
  
  //Evaluation of an aritmetic expression:
  //(2 * pi) * radius...
  //1. (2 * 3.14159) * radius
  //2. 6.28318 * radius
  //3. 6.28318 * 10
  //4. 62.8318

  def square(x: Double) = x * x                   //> square: (x: Double)Double

  square(2)                                       //> res0: Double = 4.0

  square(5 + 4)                                   //> res1: Double = 81.0

  square(square(4))                               //> res2: Double = 256.0

  //Function parameters come with their type, which is given after a colon
  //If a return type is given, it follows the parameter list. Primitive types are as in Java, but are written capitalized: Int, Double, Boolean
  def sumOfSquares(x: Double, y: Double) = square(x) + square(y)
                                                  //> sumOfSquares: (x: Double, y: Double)Double

  
  //Applications of parametrized functions are evaluated in a similar way as operators:
  //1. Evaluate all funtion arguments, from left to right.
  //2. Replace the function application by the function's right-hand side, and, at the same time
  //3. Replace the formal parameters of the function by the actual arguments.
  
  //Example:
  //sumOfSquares(3, 2 + 2) ...                          
  //1. sumOfSquares(3, 4)                              
  //2. square(3) + square(4)                          
  //3. 3 * 3 + square(4)
  //4. 9 + square(4)
  //5. 9 + 4 * 4
  //6. 9 + 16
  //7. 25

  //The substitution model
  // This scheme of expression evaluation is called the substitution model.
  // The idea underlying this model is that all evaluation does is reduce an expression to a value.
  // It can be applied to all expressions, as long as the have no side effects.
  // The substitution model is formalized in the lambda-calculus, which gives a foindation for functional programming.
  
  // Does every expression reduce to a value (in a finite number of steps)?
  // No. Here is a counter-example:
  // def loop: int = loop
  
  // There are 2 types of substitution model: call-by-name and call-by-value  
  
  //1-4--------------------------------------------------------------------
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
  val y = square(x)                               //> y  : Double = 4.0

  //The right-hand side of a val definition is evaluated at the point of the definitn itself.
  //Afterwards, the name refers to the value.
  //For instance, y above refers to 4, not to square(2)

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

  //1.7-- Tail recursion
  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)              //> gcd: (a: Int, b: Int)Int

  def factorial(n: Int): Int =
    if (n == 0) 1 else n * factorial(n - 1)       //> factorial: (n: Int)Int

  //Implemetation Consideration: If a function calls itself as its last action, the function' stack frame can be reused. This is called tail recursion.
  //=>Tail recursive functions are iterative processes.
  //In general, if the last action of a function consists of calling  a function (which may be the same), one stack frame would be sufficent for both functions. Such calls are called tail-calls.
  //A function has around 2000 stacks. if the execution goes beyond that a stackoverflow ocurrs.

  //Tail recursive version of factorial
  def factorial2(n: Int): Int = {
    def loop(acc: Int, n: Int): Int =
      if (n == 0) acc
      else loop(acc * n, n - 1)
    loop(1, n)
  }                                               //> factorial2: (n: Int)Int
  factorial2(4)                                   //> res7: Int = 24

}
