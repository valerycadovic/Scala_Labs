import org.scalatest._
import lab5.Main

class Tests extends FlatSpec with Matchers{

  it should "minimal element of list" in {
    val list = List[Int](2, 45, 43, 56, 1, 456, 45, 1, 4)
    Main.minTailrec(list) should be (1)
    Main.minRec(list) should be(1)
  }

  it should "definite integral of a function" in {
    val res0 = Main.integralRec(x => 5 * x * x - 3 * x + 5, 0.02, 1, 2)
    val res1 = Main.integralTailRec(x => 5 * x * x - 3 * x + 5, 0.02, 1, 2)

    assert(res0 === 12.167 +- 0.02)
    assert(res1 === 12.167 +- 0.02)
  }

}