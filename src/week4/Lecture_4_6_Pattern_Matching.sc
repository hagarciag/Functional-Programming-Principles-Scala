package week4

object Lecture_4_6_Pattern_Matching {
	//----------DECOMPOSITION
	//Attepts seen in the previous session
	//- Classification and access methods: cuadratic explosion
	//- Type tests and casts: unsafe, low-level
	//- Object-oriented: tocuh all the class to include a nw method
	
	//-----------OTHER APPROACH_ PATTEN MATCHING
	//A case class definition is similar to a normal class definiotn, except that it is proceded by the modifier case. For exmple:
	/*
	trait Expr
	case class Number(n: Int) extends Expr
	case class Sum(e1: Expr, e2: Expr) extends Expr
	*/
	
	//Like before, this defines a trait Expr, and two concrete subclasses Number and Sum
	
	//It also implicitly defines companion objects with apply methods.
	
	/*
	object Number {
		def apply(n: Int) = new Number(n)
	}

	object Sum {
		def apply(e1: Expr, e2: Expr) = new Sum(e1, e2)
	}
	*/
	//so you can write Number(1) instead of new Number(1).
	//However, these classes are now empty. So how can we access the members?
	
	//Pattern matching is a generalization of switch from C/Java to class hierarchies
	
	//It's expressed in Scala using the keywords match
	
	//Example:
	/*
	def eval(e: Expr): Int = e match {
		case Number(n) => n
		case Sum(e1, e2) => eval(e1) + eval(e2)
	}
	*/
	
	//rules of patterns...
	//forms of patterns...
	//evaluating match expressions...
	/*
	trait Expr {
		def eval: Int = this match {
			case Number(n) => n
			case Sum(e1, e2) => e1.eval + e2.eval
		}
	}
	*/
	val a = 1                                 //> a  : Int = 1
}