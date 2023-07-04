import main._
object ServiceFunc {
  def fillDB(): Unit = {
    for ((i, j) <- SOCIAL_NETWORK_LIST.zip(
      List(NUMBER_INSTA_BLOGGERS,
        NUMBER_TIKTOK_BLOGGERS,
        NUMBER_MIXED_BLOGGERS))) createAccounts(i, j)
  }

  def createAccounts(typeAccount: String, num: Int): Unit = {
    for (i <- 1 to num) typeAccount match {
      case "instagram" => DataBaseImitation.dataStorage(InstaBlogger(s"i$i"))
      case "tiktok" => DataBaseImitation.dataStorage(TikTokBlogger(s"t$i"))
      case "mix" => DataBaseImitation.dataStorage(TikTokBlogger(s"m$i"))
    }

  }

  def getById(id: String) = {
    val cashedAcc = Cash.cash.get(id).orNull
//    if (cashedAcc && cashedAcc._1)
      DataBaseImitation.dataStorage.getOrElse(id, "Not found")
  }

}

