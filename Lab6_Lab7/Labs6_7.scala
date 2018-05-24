package lab5

import java.util.Calendar

import scala.annotation.tailrec
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer


object Main extends App{

  def currentDate(format: String): String = {

    val array: Array[Char] = format.toCharArray
    val array_buffer_1: ArrayBuffer[String] = ArrayBuffer[String]()
    val array_buffer_2: ArrayBuffer[String] = ArrayBuffer[String]()

    for (i <- array.indices) {

      array(i) match {

        case 'Y' => array_buffer_1 += Calendar.getInstance.get(Calendar.YEAR).toString
        case 'M' => array_buffer_1 += Calendar.getInstance.get(Calendar.MONTH).toString
        case 'D' => array_buffer_1 += Calendar.getInstance.get(Calendar.DAY_OF_MONTH).toString
        case 'h' => array_buffer_1 += Calendar.getInstance.get(Calendar.HOUR).toString
        case 'm' => array_buffer_1 += Calendar.getInstance.get(Calendar.MINUTE).toString
        case 's' => array_buffer_1 += Calendar.getInstance.get(Calendar.SECOND).toString
        case _ => array_buffer_1 += array(i).toString

      }

    }

    for (i <- array_buffer_1.indices) {

      if (i == 0) array_buffer_2 += ""

      array_buffer_2(0) = array_buffer_2(0) + array_buffer_1(i)

    }

    array_buffer_2(0)

  }

  def anyToString(x: Any, delimeter: String): String = x match {
    case x: List[Int] => x.mkString(delimeter)
    case x: Int => x.toString
    case _ => ""
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
  def splitString(str: String, delimeter: String): List[String] = {
    def find(list: List[String]): List[String] = {
      if (list.tail.isEmpty)
        list
      else
        list.head :: find(list.tail.flatMap(x => x.split(delimeter, 2).toList))
    }
    if (str.isEmpty)
      Nil
    else
      find(str.split(delimeter, 2).toList)
  }

}

