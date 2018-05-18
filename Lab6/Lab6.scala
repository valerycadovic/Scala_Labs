package lab5

import scala.annotation.tailrec
import scala.collection.mutable


object Main{

  def main(args: Array[String]): Unit = {

    val a = List[Int](1, 2, 3, 4, 5, 6, 7, 3)
    val b = List[Int](5, 6, 7, 8, 9, 10, 11, 12, 3)

    println(getUnion(a, b))

    println(splitString("valera, chadovich, norm,pacan"))

  }

  // get union of two lists
  def getUnion(a: List[Int], b: List[Int]): List[Int] = {
    (a ::: b).distinct
  }

  // find minimal value in list
  def findMin(l: List[Int]): Int = {
    l.foldLeft(l.head) { (m: Int, n: Int) => if (m > n) n; else m }
  }

  // split string by ","
  def splitString(str: String): List[String] = {
    def find(list: List[String]): List[String] = {
      if (list.tail.isEmpty)
        list
      else
        list.head :: find(list.tail.flatMap(x => x.split(",", 2).toList))
    }
    if (str.isEmpty)
      Nil
    else
      find(str.split(",", 2).toList)
  }

}

