import main._

object ServiceFunc {
  def fillDB(): Unit = {
    for (i <- SOCIAL_NETWORK_LIST) createAccounts(i)
    def createAccounts(typeAccount: String): Unit = typeAccount match {
      case "Instagram" => {
        for (i <- 1 to NUMBER_INSTA_BLOGGERS)
          DataBaseImitation.dataStorage(InstaBlogger(s"i$i"))
      }
      case "TikTok" => {
        for (i <- 1 to NUMBER_TIKTOK_BLOGGERS)
          DataBaseImitation.dataStorage(TikTokBlogger(s"t$i"))
      }
      case "Mix" => {
        for (i <- 1 to NUMBER_MIXED_BLOGGERS)
          DataBaseImitation.dataStorage(TikTokBlogger(s"m$i"))
      }
    }
  }

  def getById(id:String)= {
    DataBaseImitation.dataStorage.getOrElse(id, "Not found")
  }

}

