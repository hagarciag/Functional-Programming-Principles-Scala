package week1

object Lecture_1_2_Elements_Programming {
  
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
