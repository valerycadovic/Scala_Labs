import java.util.Calendar

import org.scalatest._
import lab5.Main

class Tests extends FlatSpec with Matchers{

  it should "get distinct" in {
    val a = List(1, 2, 3)
    val b = List(2, 3, 4)

    Main.getUnion(a, b) should be (List(1, 2, 3, 4))
  }

  it should "get current date" in {
    Main.currentDate("M/D h:m") should be (
      Calendar.getInstance.get(Calendar.MONTH).toString +
        "/" +
        Calendar.getInstance.get(Calendar.DAY_OF_MONTH).toString +
        " " +
        Calendar.getInstance.get(Calendar.HOUR).toString +
        ":" +
        Calendar.getInstance.get(Calendar.MINUTE).toString
    )
  }

  it should "find minimum" in {
    val a = List(2, 1, 5, 4)
    Main.findMin(a) should be (1)
  }

  it should "split string" in {
    val a = "valera chadovich will pass all exams"
    Main.splitString(a, " ") should be (List("valera", "chadovich", "will", "pass", "all", "exams"))
  }

  it should "convert any in string" in {
    val a = 15
    val b = List(1, 2, 3, 4)

    Main.anyToString(a, "|") should be ("15")
    Main.anyToString(b, "|") should be ("1|2|3|4")
  }
}
