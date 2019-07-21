object Main extends App {
  def scaleList(xs: List[Double], factor: Double) =
    xs map (x => x * factor)
  
  val xs: List[Double] = List(1,3,4)
	print(scaleList(xs, 2))

}
