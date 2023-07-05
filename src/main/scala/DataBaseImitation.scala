import scala.collection.mutable

//object имитирующий базу данных через изменяемый Map.
// Содердит методы для добавления элемента в "базу",
// для полученея записи из "базы" по id и получения всех записей
object DataBaseImitation {
  private val dataStorage: mutable.Map[String, Blogger] = mutable.Map()

  def putToBD(newAccount: Blogger): Unit = {
    dataStorage += (newAccount.id -> newAccount)
  }

  def getFromDB(id: String): Blogger = dataStorage.get(id).orNull

  def getAll: mutable.Map[String, Blogger] = dataStorage

}

// object имитирующий кэш через изменяемый Map.
// Содержит методы добавления записи в кэш, получение записи из кэша по id, получения всех записей из кэша и
// специальный метод для создания постов в Instagram для пользователей из кэша, имеющих на это права.
// При вызове метода при необходимости происходит обновление записи в кэше.
object Cash {
  private val cash: mutable.Map[String, (Long, Blogger)] = mutable.Map()

  def putToCash(time: Long, blogger: Blogger): Unit = {
    cash += (blogger.id -> (time, blogger))
  }

  def getFromCash(id: String): (Long, Blogger) = cash.get(id).orNull

  def getAllCash: mutable.Map[String, (Long, Blogger)] = cash

  def postToInstagram(): Unit = {
    if (cash.nonEmpty) {
      val filteredCash = cash.filter((k) => k._2._2.allowedSocialNetwork.contains("instagram"))
      for ((i, _) <- filteredCash) {
        ServiceFunc.getById(i).post("I post message", "instagram")
      }

    }

  }
}