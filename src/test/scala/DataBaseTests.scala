import org.scalatest.funsuite.AnyFunSuite

class DataBaseSuiteTests extends AnyFunSuite {
  test("DB interface") {
    val blogger = TikTokBlogger("t25")
    DataBaseImitation.putToBD(blogger)
    assert(DataBaseImitation.getAll.size == 1)
    assert(DataBaseImitation.getFromDB("t25") == blogger)
    assert(DataBaseImitation.getFromDB("0") == null)
    assertTypeError("DataBaseImitation.putToBD(123)")
    assertTypeError("DataBaseImitation.getFromDB(123)")
  }

  test("Cash interface") {
    val blogger = TikTokBlogger("t25")
    DataBaseImitation.putToBD(blogger)
    val time = System.currentTimeMillis()
    Cash.putToCash(time, blogger)
    assert(Cash.getAllCash.size == 1)

    val cashedAcc = Cash.getFromCash("t25")
    assert(cashedAcc._2 == blogger)
    assert(cashedAcc._1 == time)

    assertTypeError("Cash.putToCash(3, \"blogger\")")

  }
}
