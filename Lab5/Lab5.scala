package lab5

import scala.annotation.tailrec


object Main extends App{

  // Вариант 2: Найти минимальное число в списке
  def minRec(listOfNum: List[Int]): Int = {

    def find(listNum: List[Int], min: Int): Int = {
      if(listNum.lengthCompare(min) > 0) {
        val next = find(listNum, min + 1)
        if(listNum(min) < next)
          listNum(min)
        else
          next
      }
      else
        listNum.head
    }
    find(listOfNum, 0)
  }

  def minTailrec(listOfNum: List[Int]): Int = {

    @tailrec
    def find(listOfNumbers: List[Int], current: Int, min: Int): Int = {
      if (current < listOfNumbers.length)
        find(listOfNumbers, current + 1, math.min(listOfNumbers(current), min))
      else
        min
    }
    find(listOfNum, 0, listOfNum.head)

  }


  // 8. Найти комбинации двух положительных чисел, дающие в сумме введённое значение
  def combos(sum: Int): List[String] = {
    @tailrec
    def find(a: Int, b: Int, list: List[String]): List[String] = {
      if(a <= b){
        find(a + 1, b - 1, list ::: List[String](a.toString + " + " + b.toString + " = " + sum.toString))
      } else {
        list
      }
    }

    find(1, sum - 1, Nil)
  }


  // Вариант 11:  Найти определённый интеграл методом трапеций
  def integralTailRec(f: Double => Double, delta: Double, a: Double, b: Double): Double = {

    @tailrec
    def find(a: Double, acc: Double): Double ={
      if(a <= b)
        find(a + delta, acc + f(a) * delta + (f(a + delta) - f(a)) * delta / 2)
      else
        acc
    }
    find(a, 0)
  }

  def integralRec(f: Double => Double, delta: Double, a: Double, b: Double): Double ={
    def find(a: Double): Double = {
      if(a <= b)
        f(a) * delta + (f(a + delta) - f(a)) * delta / 2 + find(a + delta)
      else
        0
    }
    find(a)
  }
}

