import org.scalatest.funsuite.AnyFunSuite

class DataBaseSuite extends AnyFunSuite {
  test("DB interface") {
    val blogger = TikTokBlogger("t25")
    DataBaseImitation.putToBD(blogger)
    assert(DataBaseImitation.getAll().size == 1)
    assert(DataBaseImitation.getFromDB("t25") == blogger)
    assert(DataBaseImitation.getFromDB("0") == null)
    assertTypeError("DataBaseImitation.putToBD(123)")
    assertTypeError("DataBaseImitation.getFromDB(123)")
  }

//  test("Cash interface") {
//    val blogger = TikTokBlogger("t25")
//    DataBaseImitation.putToBD(blogger)
//    assert(DataBaseImitation.getAll().size == 1)
//    assert(DataBaseImitation.getFromDB("t25") == blogger)
//    assert(DataBaseImitation.getFromDB("0") == null)
//    assertTypeError("DataBaseImitation.putToBD(123)")
//    assertTypeError("DataBaseImitation.getFromDB(123)")
//  }
}
