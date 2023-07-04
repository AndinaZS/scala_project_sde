
import scala.util.Random

object ServiceFunc {

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
      case _ => println("unable to create accounts"); return
    }

  }

  def getById(id: String): (Blogger) = {
    val cashedAcc = Cash.getFromCash(id)
    if (cashedAcc != null && (System.currentTimeMillis() - cashedAcc._1) < 10 * 60 * 1000) cashedAcc._2
    else if (DataBaseImitation.getFromDB(id) != null)
      Cash.putToCash(System.currentTimeMillis(), DataBaseImitation.getFromDB(id))
    Cash.getFromCash(id)._2
  }

}

