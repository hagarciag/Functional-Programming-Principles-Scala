package week5

object Lecture_5_2_MergeSort_Implementation {

  /*
  //Without pairs
	def merge(xs: List[Int], ys: List[Int]): List[Int]=
		xs match {
			case Nil =>
				ys
			case x :: xs1 =>
				ys match {
					case Nil =>
						xs
					case y :: ys1 =>
						if(x < y) x :: merge(xs1, ys)
						else
						y :: merge(xs, ys1)
				}
			}
	*/
	
	//With
  def merge(xs: List[Int], ys: List[Int]): List[Int] =
    (xs, ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (x :: xs1, y :: ys1) =>
        if (x < y) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
    }                                             //> merge: (xs: List[Int], ys: List[Int])List[Int]

  //mergesort
  def msort(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      //def merge(xs: List[Int], ys: List[Int]) = ???
      val (fst, snd) = xs splitAt n
      merge(msort(fst), msort(snd))
    }
  }                                               //> msort: (xs: List[Int])List[Int]
  
  val nums = List (2, -4, 5, 7, 1)                //> nums  : List[Int] = List(2, -4, 5, 7, 1)
  msort(nums)                                     //> res0: List[Int] = List(-4, 1, 2, 5, 7)
}