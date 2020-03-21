package Week2

/*
class Rational(x: Int, y: Int){
	require(y != 0, "denominator must different from zero")

	//Second constructor of the class besides the primary one
	def this(x: Int) = this(x, 1)

	private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
	private val g = gcd(x, y)
	//These x and y could be defined as val to avoid its calcutation each time. Whatever implementation is choose the client call is not affected. This is data abstraction. This is the client does not have to change anything whatever implementation is choosen.
	def numer = x/g
	def denom = y/g
	
	def less(that: Rational) = numer * that.denom < that.numer * denom

	//The previous one might be defined as fllows...
	def <(that: Rational) = numer * that.denom < that.numer * denom

	//This: self-reference
	//def max(that: Rational) = if(this.less(that)) that else this

	//This is a redefinition of the previous to show how to use <
	def max(that: Rational) = if(this < that) that else this
	
	def add(that: Rational) =
		new Rational(
			((numer * that.denom) + (that.numer * denom)),
			denom * that.denom)

	//This is done to show that a name of a function coulbe named as a symbol, this case +
	def + (x: Rational) = add(x)

	def neg : Rational = new Rational(-numer, denom)

	//The operator used("-" in thi case) must be separated from the semicolon(:) to avoid erros
	def unary_- : Rational = new Rational(-numer, denom)

	def sub(that: Rational) = add(that.neg)
	
	//The previous is redefined
	def - (that:Rational) = this + -that
			
	override def toString = numer + "/" + denom
}
*/

object Lecture2_FunctionsAndData {
	//val x = new Rational(1, 2)
	val x = new Rational(1, 3)                //> x  : Week2.Rational = 1/3
	val y = new Rational(5, 7)                //> y  : Week2.Rational = 5/7
	val z = new Rational(3, 2)                //> z  : Week2.Rational = 3/2
	x.numer                                   //> res0: <error> = 1
	x.denom                                   //> res1: <error> = 3
	
	//val y = new Rational(2, 3)
	//x.add(y)
	x.sub(y).sub(z)                           //> res2: <error> = -79/42
	x - y - z                                 //> res3: <error> = -79/42
	y.add(y)                                  //> res4: <error> = 10/7
	y+y                                       //> res5: <error> = 10/7
	x.less(y)                                 //> res6: <error> = true
	x < y                                     //> res7: <error> = true
	x.max(y)                                  //> res8: Week2.Rational = 5/7
	x max y                                   //> res9: Week2.Rational = 5/7
	
	//Calling the second constructor
	new Rational(2)                           //> res10: Week2.Rational = 2/1
	
	val strange = new Rational(1, 0)          //> java.lang.IllegalArgumentException: requirement failed: denominator must di
                                                  //| fferent from zero
                                                  //| 	at scala.Predef$.require(Predef.scala:277)
                                                  //| 	at Week2.Rational.<init>(Rational.scala:4)
                                                  //| 	at Week2.Lecture2_FunctionsAndData$.$anonfun$main$1(Week2.Lecture2_Funct
                                                  //| ionsAndData.scala:71)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$anonfun$$ex
                                                  //| ecute$1(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:76)
                                                  //| 	at Week2.Lecture2_FunctionsAndData$.main(Week2.Lecture2_FunctionsAndData
                                                  //| .scala:49)
                                                  //| 	at Week2.Lecture2_FunctionsAndData.main(Week2.Lecture2_FunctionsAndData.
                                                  //| scala)
	strange.add(strange)
}