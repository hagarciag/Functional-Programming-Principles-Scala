package week6

object Lecture_6_3_Combinatorial_Search_Example {
  //Sets are another basic abstraction in the Scala collections.

  //A set is written analogously to a sequence:

  val fruit = Set("apple", "banana", "pear")      //> fruit  : scala.collection.immutable.Set[String] = Set(apple, banana, pear)
  val s = (1 to 6).toSet                          //> s  : scala.collection.immutable.Set[Int] = Set(5, 1, 6, 2, 3, 4)

  //Most operations on sequences are also available on sets:

  s map (_ + 2)                                   //> res0: scala.collection.immutable.Set[Int] = Set(5, 6, 7, 3, 8, 4)

  fruit filter (_.startsWith("app"))              //> res1: scala.collection.immutable.Set[String] = Set(apple)
  s.nonEmpty                                      //> res2: Boolean = true

  //The principal differences between sets and sequences are:
  //1. Sets are unordered; the elements of a set don to have a predefined order in which they appear in the set.
  //2. Sets do not have duplicate elements:
  s map (_ / 2)                                   //> res3: scala.collection.immutable.Set[Int] = Set(2, 0, 3, 1)

  //3. The fundamental operation on sets is contains:

  s contains 5                                    //> res4: Boolean = true

  //The eight queens problem is to place eight queens on a chessboard
  //so that no queen is threatened by another

  def queens(n: Int): Set[List[Int]] = {
    def placeQueens(k: Int): Set[List[Int]] =
      if (k == 0) Set(List())
      else
        for {
          queens <- placeQueens(k - 1)
          col <- 0 until n
          if isSafe(col, queens)
        } yield col :: queens
      placeQueens(n)
    }                                             //> queens: (n: Int)Set[List[Int]]
    
    def isSafe(col: Int, queens: List[Int]): Boolean = {
      val row = queens.length
      val queensWithRow = (row - 1 to 0 by -1) zip queens
      queensWithRow forall {
        case (r, c) => col != c && math.abs(col - c) != row - r
      }
    }                                             //> isSafe: (col: Int, queens: List[Int])Boolean
    
    def show(queens: List[Int]) = {
      val lines =
        for (col <- queens.reverse)
          yield Vector.fill(queens.length)("* ").updated(col, "X ").mkString
      "\n" + (lines mkString "\n")
    }                                             //> show: (queens: List[Int])String

    (queens(4) map show) mkString "\n"            //> res5: String = "
                                                  //| * * X * 
                                                  //| X * * * 
                                                  //| * * * X 
                                                  //| * X * * 
                                                  //| 
                                                  //| * X * * 
                                                  //| * * * X 
                                                  //| X * * * 
                                                  //| * * X * "
  
  //17500
  //4000
}