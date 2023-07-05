import org.scalatest.funsuite.AnyFunSuite

class DataBaseSuiteTests extends AnyFunSuite {
  val blogger = TikTokBlogger("t25")

  test("DB positive test - add to DB") {
    DataBaseImitation.putToBD(blogger)
    assert(DataBaseImitation.getAll.size == 1)
     }
  test("DB negative test - add to DB with wrong arguments") {
    assertTypeError("DataBaseImitation.putToBD(123)")
  }
  test("DB positive test - get from DB existed account") {
    assert(DataBaseImitation.getFromDB("t25") == blogger)
  }
  test("DB positive test - get from DB account not exisis") {
    assert(DataBaseImitation.getFromDB("0") == null)
  }
  test("DB negative test - get from DB with wrong arguments") {
    assertTypeError("DataBaseImitation.getFromDB(123)")
  }


}
