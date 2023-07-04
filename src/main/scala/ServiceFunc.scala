import main._
import scala.util.Random

object ServiceFunc {
  def fillDB(): Unit = {
    for ((i, j) <- SOCIAL_NETWORK_LIST.zip(
      List(NUMBER_INSTA_BLOGGERS,
        NUMBER_TIKTOK_BLOGGERS,
        NUMBER_MIXED_BLOGGERS))) createAccounts(i, j)
  }

  def fillCash(): Unit = {
    while (Cash.getAllCash().size < DataBaseImitation.getAll().size * 0.33) {
      val listID: List[String] = DataBaseImitation.getAll().keys.toList
      getById(listID(Random.nextInt(listID.size)))
    }
  }
  def createAccounts(typeAccount: String, num: Int): Unit = {
    for (i <- 1 to num) typeAccount match {
      case "instagram" => DataBaseImitation.putToBD(InstaBlogger(s"i$i"))
      case "tiktok" => DataBaseImitation.putToBD(TikTokBlogger(s"t$i"))
      case "mix" => DataBaseImitation.putToBD(Mixed(s"m$i"))
    }

  }

  def getById(id: String) = {
    val cashedAcc = Cash.cash.get(id).orNull
    if (cashedAcc != null && (System.currentTimeMillis() - cashedAcc._1) < 10 * 60 * 1000) cashedAcc._2
    else if (DataBaseImitation.getFromDB(id) != null)
      Cash.putToCash(System.currentTimeMillis(), DataBaseImitation.getFromDB(id))
  }

}

