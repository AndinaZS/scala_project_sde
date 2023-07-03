import scala.collection.mutable
object DataBaseImitation {
  var dataStorage: Map[String, _ <: Blogger] = Map()

  def dataStorage[T <: Blogger](newAccount: T): Unit = {
    dataStorage += (newAccount.id -> newAccount)
  }
}