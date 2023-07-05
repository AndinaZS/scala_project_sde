import org.scalatest.funsuite.AnyFunSuite

class FillCashTest extends AnyFunSuite {
  ServiceFunc.createAccounts("instagram", 5)
  ServiceFunc.createAccounts("tiktok", 5)
  ServiceFunc.createAccounts("mix", 5)

  test("fillCash positive test") {
    //      проверка на наполнение кэша
    ServiceFunc.fillCash()
    assert(Cash.getAllCash.size == 15 / 3)
  }
  test("fillCash negative test - wrong parameters") {
    assertDoesNotCompile("ServiceFunc.fillCash(5)")

  }
}

