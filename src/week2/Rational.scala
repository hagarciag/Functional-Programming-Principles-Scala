package week2

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
