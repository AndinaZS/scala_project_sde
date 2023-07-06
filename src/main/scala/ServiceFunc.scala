import scala.util.Random
//Object для реализации сервисных методов

object ServiceFunc {

  //Метод для заполнения кэша третью от имеющихся в базе данных учетных записей
  def fillCash(): Unit = {
    while (Cash.getAllCash.size < DataBaseImitation.getAll.size / 3) {
      val listID: List[String] = DataBaseImitation.getAll.keys.toList
      getById(listID(Random.nextInt(listID.size)))
    }
  }

  //Метод для массового создания учетных записей определенного типа.
  // При получении недопустимого типа учетной записи выдает оповещение и завершает работу.
  def createAccounts(typeAccount: String, num: Int): Unit = {
    for (i <- 1 to num) typeAccount match {
      case "instagram" => DataBaseImitation.putToBD(InstaBlogger(s"i$i"))
      case "tiktok" => DataBaseImitation.putToBD(TikTokBlogger(s"t$i"))
      case "mix" => DataBaseImitation.putToBD(Mixed(s"m$i"))
      case _ => println("unable to create accounts"); return
    }

  }

  //Метод вызова учетной записи по id из кэша.
  // При отсутствии записи в кэше или если она устарела (хранится более 10 мин)
  // получает запись из базы данных методом объекта базы данных и кладет ее в кэш, после чего возвращает ее из кэша.
  def getById(id: String): Post = {
    val cashedAcc = Cash.getFromCash(id)
    if (cashedAcc != null && (System.currentTimeMillis() - cashedAcc._1) < 10 * 60 * 1000) cashedAcc._2
    else if (DataBaseImitation.getFromDB(id) != null)
      Cash.putToCash(System.currentTimeMillis(), DataBaseImitation.getFromDB(id))
    Cash.getFromCash(id)._2
  }

}

