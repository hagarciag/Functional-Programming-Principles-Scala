package week6

object Lecture_6_4_Maps {
	val romanNumeral = Map("I" -> 1, "V" -> 5, "X" -> 10)
                                                  //> romanNumeral  : scala.collection.immutable.Map[String,Int] = Map(I -> 1, V ->
                                                  //|  5, X -> 10)
	val capitalOfCountry = Map("US" -> "Washington", "Switzerland" -> "Bern")
                                                  //> capitalOfCountry  : scala.collection.immutable.Map[String,String] = Map(US -
                                                  //| > Washington, Switzerland -> Bern)
	
	//Maps are iterable and they are also functions
	capitalOfCountry("US")                    //> res0: String = Washington

	//If the key does exist it would thow an error
	//capitalOfCountry("Andorra")
	capitalOfCountry get "Andorra"            //> res1: Option[String] = None

	capitalOfCountry get "US"                 //> res2: Option[String] = Some(Washington)

	val fruit = List("apple", "pear", "orange", "pineapple")
                                                  //> fruit  : List[String] = List(apple, pear, orange, pineapple)
	fruit sortWith (_.length < _.length)      //> res3: List[String] = List(pear, apple, orange, pineapple)
	fruit.sorted                              //> res4: List[String] = List(apple, orange, pear, pineapple)

	//groupBy is available on Scala collections. It partitions a collection into a map
	//of collections according to a discriminator function f.
	
	fruit groupBy (_.head)                    //> res5: scala.collection.immutable.Map[Char,List[String]] = Map(p -> List(pear
                                                  //| , pineapple), a -> List(apple), o -> List(orange))
	//Version with ++
	class Poly(val terms0: Map[Int, Double]){
		def this(bindings:(Int, Double)*) = this(bindings.toMap)
		val terms = terms0 withDefaultValue 0.0
		def + (other: Poly) = new Poly(terms ++ (other.terms map adjust))
		def adjust(term: (Int, Double)): (Int, Double) = {
			val (exp, coeff) = term
			exp -> (coeff + terms(exp))
			/*
			terms get exp match {
				case Some(coeff1) => exp -> (coeff + coeff1)
				case None => exp -> coeff
			}
			*/
		}
		override def toString =
			(for ((exp, coeff)<- terms.toList.sorted.reverse) yield coeff+"x^"+exp) mkString " + "
	}

	//val p1 = new Poly(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.2))
	val p1 = new Poly(1 -> 2.0, 3 -> 4.0, 5 -> 6.2)
                                                  //> p1  : week6.Lecture_6_4_Maps.Poly = 6.2x^5 + 4.0x^3 + 2.0x^1


	val p2 = new Poly(Map(0 -> 3.0, 3 -> 7.0))//> p2  : week6.Lecture_6_4_Maps.Poly = 7.0x^3 + 3.0x^0

	
	p1 + p2                                   //> res6: week6.Lecture_6_4_Maps.Poly = 6.2x^5 + 11.0x^3 + 2.0x^1 + 3.0x^0
	p1.terms(7)                               //> res7: Double = 0.0

	//So far, maps were partial functions: Applying a map to a key value
	//in map(key) could lead to an exception, if the key was not stored in
	//the map.
	
	//There is an operation withDefaultValue that turns a map into a
	//total function:
	val cap1 = capitalOfCountry withDefaultValue "<unknown>"
                                                  //> cap1  : scala.collection.immutable.Map[String,String] = Map(US -> Washingto
                                                  //| n, Switzerland -> Bern)
	cap1("Andorra")                           //> res8: String = <unknown>

	///////////////////////////////////////////////////////////////////////////
	
	//Version with foldLeft, this is more efficienti because it makes operation immediately while the previous one concatenate and later makes the opperation
	class Poly1(val terms0: Map[Int, Double]){
		def this(bindings:(Int, Double)*) = this(bindings.toMap)
		val terms = terms0 withDefaultValue 0.0
		def + (other: Poly1) = new Poly1((other.terms foldLeft terms)(addTerm))
		def addTerm(terms: Map[Int,Double], term: (Int, Double)): Map[Int, Double] = {
			val (exp, coeff) = term
			terms + (exp -> (coeff + terms(exp)))
		}
		override def toString =
			(for ((exp, coeff)<- terms.toList.sorted.reverse) yield coeff+"x^"+exp) mkString " + "
	}
	
}