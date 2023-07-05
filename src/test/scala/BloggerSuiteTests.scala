import org.scalatest.funsuite.AnyFunSuite

class BloggerSuiteTests extends AnyFunSuite {
  val instaBlogger: InstaBlogger = InstaBlogger("i15")

  test("Create InstaBlogger positive test") {
    assert(instaBlogger.isInstanceOf[InstaBlogger])
    assert(instaBlogger.id == "i15")
  }
  test("Create InstaBlogger negative test - wrong parameters") {
    assertTypeError("InstaBlogger(15)")
  }

  test("InstaBlogger Post Messages positive test - allowed social network") {
    val stream1 = new java.io.ByteArrayOutputStream()
    Console.withOut(stream1) {
      instaBlogger.post("some message", "instagram")
    }
    assert(stream1.toString.trim == "i15 send 'some message' to instagram")
  }

  test("InstaBlogger Post Messages positive test - wrong social network") {
    val stream = new java.io.ByteArrayOutputStream()
    Console.withOut(stream) {
      instaBlogger.post("some message", "tiktok")
    }
    assert(stream.toString.trim == "not allowed")
  }

  test("InstaBlogger Post Messages negative test - wrong arguments") {
    assertTypeError("instaBlogger.post(15.3, \"instagram\")")
    assertTypeError("instaBlogger.post(\"some message\",true)")
  }
}

