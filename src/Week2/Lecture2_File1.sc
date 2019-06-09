package Week2

object Lecture2_File1 {
	// Functions Returning Functions
	def sum(f: Int=>Int): (Int, Int) => Int = {
		def sumF(a: Int, b: Int): Int =
			if(a>b) 0
			else f(a) + sumF(a+1, b)
		sumF
	}                                         //> sum: (f: Int => Int)(Int, Int) => Int
	
	def sumInts = sum(x=>x)                   //> sumInts: => (Int, Int) => Int
	sumInts(1, 3)                             //> res0: Int = 6
	sum(x=>x)(1, 3)                           //> res1: Int = 6
	
	//Currying: Multiple Parameter Lists. It's the same that the previous, but differente notation
	def sum2(f: Int=>Int)(a: Int, b:Int): Int =
			if(a>b) 0 else f(a) + sum2(f)(a+1, b)
                                                  //> sum2: (f: Int => Int)(a: Int, b: Int)Int
	sum2(x=>x)(1, 3)                          //> res2: Int = 6
	
	def product (f: Int => Int) (a: Int, b: Int): Int =
		if (a > b)	1
		else f(a) * product(f)(a + 1, b)  //> product: (f: Int => Int)(a: Int, b: Int)Int
	product(x=>x*x)(3,4)                      //> res3: Int = 144
				
	def fact(n: Int) = product(x=>x)(1, n)    //> fact: (n: Int)Int
	fact(5)                                   //> res4: Int = 120
	
	//Sum or multiply between some boundaries.
	def mapReduce(f: Int=>Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:Int): Int =
	 if (a > b) zero
	 else combine(f(a), mapReduce(f, combine, zero)(a+1,b))
                                                  //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:
                                                  //|  Int)Int
	 
	def product1 (f: Int => Int) (a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)
                                                  //> product1: (f: Int => Int)(a: Int, b: Int)Int
	product1(x=>x)(1,5)                       //> res5: Int = 120
	
	def sum3 (f: Int => Int) (a: Int, b: Int): Int = mapReduce(f, (x, y) => x + y, 0)(a, b)
                                                  //> sum3: (f: Int => Int)(a: Int, b: Int)Int
	sum3(x=>x)(1,3)                           //> res6: Int = 6
}