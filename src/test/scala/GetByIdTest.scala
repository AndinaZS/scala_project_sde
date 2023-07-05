import org.scalatest.funsuite.AnyFunSuite

class GetByIdTest extends AnyFunSuite {
  //  создаем блоггера для тестирования и кладем его в базу
  val blogger = InstaBlogger("i1")
  DataBaseImitation.putToBD(blogger)

  test("getById positive test") {
    // тест на получение блогера по id - проверяем, что блоггер правильный и что кэш пополнился
    assert(ServiceFunc.getById("i1") == blogger)
    assert(Cash.getAllCash.size == 1)
  }
  test("getById positive test - refresh cash") {
    //    проверяем, что вызов getById обновляет записи кэша, если запись хранится более 10 мин
    val time_10: Long = System.currentTimeMillis() - 60 * 10 * 1000
    Cash.putToCash(time_10, blogger)
    assert(Cash.getFromCash("i1")._1 == time_10)
    ServiceFunc.getById("i1")
    assert(Cash.getFromCash("i1")._1 > time_10)
  }
  test("getById positive test - don't refresh cash") {
    //    проверяем, что вызов getById не обновляет записи кэша, если запись хранится менее 10 мин
    val time_3: Long = System.currentTimeMillis() - 60 * 3 * 1000
    Cash.putToCash(time_3, blogger)
    assert(Cash.getFromCash("i1")._1 == time_3)
    ServiceFunc.getById("i1")
    assert(Cash.getFromCash("i1")._1 == time_3)
  }
  test("getById negative tests - wrong parameters") {
    assertTypeError("ServiceFunc.getById(4)")
    assertDoesNotCompile("ServiceFunc.getById()")
  }
}


