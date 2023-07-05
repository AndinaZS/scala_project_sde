import org.scalatest.funsuite.AnyFunSuite

class CashSuiteTests extends AnyFunSuite {
  val blogger = TikTokBlogger("t25")
  DataBaseImitation.putToBD(blogger)
  val time = System.currentTimeMillis()

  test("Cash. Add to cash positive test") {
    Cash.putToCash(time, blogger)
    assert(Cash.getAllCash.size == 1)
  }
  test("Cash. Add to cash negative test - wrong arguments") {
    assertTypeError("Cash.putToCash(3, \"blogger\")")
  }

  test("Cash. Get from cash by id positive test") {
    val cashedAcc = Cash.getFromCash("t25")
    assert(cashedAcc._2 == blogger)
    assert(cashedAcc._1 == time)
  }

  test("Cash. Get from cash by id negative test - wrong arguments") {
    assertTypeError("Cash.getFromCash(30.5)")
  }
}
