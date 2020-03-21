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

}
