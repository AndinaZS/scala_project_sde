import scala.collection.mutable
object DataBaseImitation {
  private val dataStorage: mutable.Map[String, Blogger] = mutable.Map()
  def putToBD(newAccount: Blogger): Unit = {
    dataStorage += (newAccount.id -> newAccount)
  }
  def getFromDB(id: String): Blogger = dataStorage.get(id).orNull
  def getAll: mutable.Map[String, Blogger] = dataStorage

}

object Cash {
  private val cash : mutable.Map[String, (Long, Blogger)] = mutable.Map()

  def putToCash(time: Long, blogger: Blogger): Unit = {
    cash += (blogger.id -> (time, blogger))
  }
  def getFromCash(id: String): (Long, Blogger) = cash.get(id).orNull

  def getAllCash: mutable.Map[String, (Long, Blogger)] = cash

  def postToInstagram(): Unit = {
    if (cash.nonEmpty) {
      val filteredCash = cash.filter((k) => k._2._2.allowedSocialNetwork.contains("instagram"))
      for ((i, _) <- filteredCash){
        ServiceFunc.getById(i).post("I post message", "instagram")
      }

    }

  }
}