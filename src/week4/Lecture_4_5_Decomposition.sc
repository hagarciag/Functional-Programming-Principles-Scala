package week4

object Lecture_4_5_Decomposition {
	//-------OBJECT-ORIENTED DECOMPOSITION
	trait Expr{
		def eval: Int
	}
	
	class Number(n: Int) extends Expr{
		def eval: Int = n
	}
	
	class Sum(e1: Expr, e2: Expr) extends Expr {
		def eval: Int = e1.eval + e2.eval
	}
}