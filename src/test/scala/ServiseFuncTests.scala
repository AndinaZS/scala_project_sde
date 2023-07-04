import org.scalatest.funsuite.AnyFunSuite

class ServiseFuncSuitTests extends AnyFunSuite {
  test("createAccounts test") {
    ServiceFunc.createAccounts("mix", 5)
    assert(DataBaseImitation.getAll().size == 5)

    val stream = new java.io.ByteArrayOutputStream()
    Console.withOut(stream) {
      ServiceFunc.createAccounts("unknown", 5)
    }
    assert(stream.toString.trim == "unable to create accounts")

    assertTypeError("ServiceFunc.createAccounts(\"mix\", 5.3)")
    assertTypeError("ServiceFunc.createAccounts(45, 4)")
    assertDoesNotCompile("ServiceFunc.createAccounts()")
  }

  test("getById test") {
    val blogger = InstaBlogger("i1")
    DataBaseImitation.putToBD(blogger)
    assert(ServiceFunc.getById("i1") == blogger)
    assert(Cash.getAllCash().size == 1)

    val time1: Long = System.currentTimeMillis() - 60 * 10 * 1000
    Cash.putToCash(time1, blogger)
    assert(Cash.getFromCash("i1")._1 == time1)
    ServiceFunc.getById("i1")
    assert(Cash.getFromCash("i1")._1 > time1)

    val time: Long = System.currentTimeMillis() - 60 * 3 * 1000
    Cash.putToCash(time, blogger)
    assert(Cash.getFromCash("i1")._1 == time)
    ServiceFunc.getById("i1")
    assert(Cash.getFromCash("i1")._1 == time)

    assertTypeError("ServiceFunc.getById(4)")
    assertDoesNotCompile("ServiceFunc.getById()")
  }

  test("fillCash test") {
    //    ServiceFunc.createAccounts("mix", 5)
    //    assert(DataBaseImitation.getAll().size == 5)
    //
    //    assertTypeError("ServiceFunc.createAccounts(\"mix\", 5.3)")
    //    assertTypeError("ServiceFunc.createAccounts(45, 4)")

  }
}