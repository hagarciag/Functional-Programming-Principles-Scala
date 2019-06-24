package Week2

object Lecture1_Higher_Order_Functions {
	//Summing with Higher-Order Functions
	//Let's define:
	def sum(f: Int => Int, a: Int, b: Int): Int =
		if(a > b) 0
		else f(a) + sum(f, a + 1, b)      //> sum: (f: Int => Int, a: Int, b: Int)Int

	//We can then write:
	def sumInts(a: Int, b: Int) = sum(id, a, b)
                                                  //> sumInts: (a: Int, b: Int)Int
	def sumcubes(a: Int, b: Int) = sum(cube, a, b)
                                                  //> sumcubes: (a: Int, b: Int)Int

	
	// Where
	def id(x: Int): Int = x                   //> id: (x: Int)Int
	def cube(x: Int): Int = x*x*x             //> cube: (x: Int)Int
	




}