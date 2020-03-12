package Week2

object Lecture1_Higher_Order_Functions {
	//********* A higher-order function takes other functions as a parameter or returns a function as a result.*******
	
	//Take the sum of the integers beetween a and b
	def sumInts0(a: Int, b: Int): Int =
		if(a > 0) 0 else a + sumInts0(a + 1, b)
                                                  //> sumInts0: (a: Int, b: Int)Int
		
	//Take the sum of the cubes of all the integers between a and b
	def cube0(x: Int): Int = x*x*x            //> cube0: (x: Int)Int
	
	def sumCubes0(a: Int, b: Int): Int =
		if(a > 0) 0 else cube0(a) + sumCubes0(a + 1, b)
                                                  //> sumCubes0: (a: Int, b: Int)Int
}
