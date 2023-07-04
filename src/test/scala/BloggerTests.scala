import org.scalatest.funsuite.AnyFunSuite

class BloggerSuite extends AnyFunSuite {

  test("Create InstaBlogger") {
    assert(InstaBlogger("i15").isInstanceOf[InstaBlogger])
    assert(InstaBlogger("i15").id == "i15")
    assertTypeError("InstaBlogger(15)")
  }

  test ("InstaBlogger Post Messages") {
    val instaBlogger = InstaBlogger("i15")

    assertTypeError("instaBlogger.post(15.3, \"instagram\")")
    assertTypeError("instaBlogger.post(\"some message\",true)")

    val stream = new java.io.ByteArrayOutputStream()
    Console.withOut(stream) {instaBlogger.post("some message", "tiktok")}
    assert(stream.toString.trim == "not allowed")

    val stream1 = new java.io.ByteArrayOutputStream()
    Console.withOut(stream1) {instaBlogger.post("some message", "instagram")}
    assert(stream1.toString.trim == "i15 send 'some message' to instagram")
  }
}

