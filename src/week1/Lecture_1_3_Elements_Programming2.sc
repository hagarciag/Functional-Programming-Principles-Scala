package week1

object Lecture_1_3_Elements_Programming {

//1.3------------------------------------------------------------------


  //Call-by-name and call-by-value
  //If CBV evaluation of an expression e terminates, then CBN evaluation of e terminates too.
  //The other way is not true
  def first(x: Int, y: Int) = x

	//THIS DEFINITION IS THE ONE WHICH PRODUCES THE ERROR. HOWEVER IT DOES NOT HAPPEN IN THE EXPLANATORY COURSE
  def loop: Int = loop
  
  //CBN
  first(1, loop)

  //CBV -- It does not finish never
  first(1, loop)

  //Scala normally uses call-by-value
  //But if the type of a function parameters stars with => it uses call-by-name

  //Example:
  def constOne(x: Int, y: => Int) = 1

  //By name
  constOne(1 + 2, loop) //1
  //First paramter is called by value and the second by name, so the fnction runs without problem
  constOne(loop, 1 + 2) //infinite loop
  //Both parameters are reduceb by value, so the function enters in an infinite loop


}