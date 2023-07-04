import scala.collection.mutable
object DataBaseImitation {
  var dataStorage: mutable.Map[String, Blogger] = mutable.Map()

  def dataStorage(newAccount: Blogger): Unit = {
    dataStorage += (newAccount.id -> newAccount)
  }
}

object Cash {
  var cash: mutable.Map[String, (Long, Blogger)] = mutable.Map()

}