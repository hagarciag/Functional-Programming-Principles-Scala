package week3

object nth {
	def nth[T](n: Int, xs: List[T]):T=
		if(xs.isEmpty) throw new IndexOutOfBoundsException
		else if(n==0) xs.head
		else nth(n-1, xs.tail)            //> nth: [T](n: Int, xs: week3.List[T])T
	val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))
                                                  //> list  : week3.Cons[Int] = week3.Cons@7c75222b
	
	nth(2, list)                              //> res0: Int = 3
	nth(-1, list)                             //> java.lang.IndexOutOfBoundsException
                                                  //| 	at week3.nth$.nth$1(week3.nth.scala:5)
                                                  //| 	at week3.nth$.$anonfun$main$1(week3.nth.scala:11)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$anonfun$$ex
                                                  //| ecute$1(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:76)
                                                  //| 	at week3.nth$.main(week3.nth.scala:3)
                                                  //| 	at week3.nth.main(week3.nth.scala)
}