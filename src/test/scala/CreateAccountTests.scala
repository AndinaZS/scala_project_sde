import org.scalatest.funsuite.AnyFunSuite

class CreateAccountTests extends AnyFunSuite {

  test("createAccounts positive test") {
    // позитивный сценарий массового создания ученых записей
    ServiceFunc.createAccounts("mix", 5)
    assert(DataBaseImitation.getAll.size == 5)
    println("createAccounts positive test")
  }

  test("createAccounts negative test - wrong social network") {
    // негативные сценарий массового создания ученых записей
    //    неверный тип соцсети
    val stream = new java.io.ByteArrayOutputStream()
    Console.withOut(stream) {
      ServiceFunc.createAccounts("unknown", 5)
    }
    assert(stream.toString.trim == "unable to create accounts")
  }

  test("createAccounts negative tests - wrong parameter types") {
    // неверные типы данных в переметрах
    assertTypeError("ServiceFunc.createAccounts(\"mix\", 5.3)")
    assertTypeError("ServiceFunc.createAccounts(45, 4)")
    assertDoesNotCompile("ServiceFunc.createAccounts()")
  }
}