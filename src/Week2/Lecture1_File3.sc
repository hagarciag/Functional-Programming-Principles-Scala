package Week2

object Lecture1_File3 {
	def sum1(f: Int => Int, a: Int, b: Int): Int =
		if(a > b) 0
		else f(a) + sum1(f, a + 1, b)     //> sum1: (f: Int => Int, a: Int, b: Int)Int

	//Defining the functions of the file 2 with anonymous functions
	def sumInts(a: Int, b: Int) = sum1(x=>x, a, b)
                                                  //> sumInts: (a: Int, b: Int)Int
	def sumcubes(a: Int, b: Int) = sum1(x=>x*x*x, a, b)
                                                  //> sumcubes: (a: Int, b: Int)Int

	//Defining the functions of the file 2 with anonymous functions and recursive loop
	def sum3(f: Int => Int, a: Int, b: Int) = {
		def loop (a: Int, acc: Int): Int = {
			if(a > b) acc
			else loop(a + 1, f(a)+acc)
		}
	}                                         //> sum3: (f: Int => Int, a: Int, b: Int)Unit
}