object main extends App {
  val NUMBER_TIKTOK_BLOGGERS: Int = 5
  val NUMBER_INSTA_BLOGGERS: Int = 5
  val NUMBER_MIXED_BLOGGERS: Int = 5
  val SOCIAL_NETWORK_LIST: List[String] = List[String]("instagram", "tiktok", "mix")


  ServiceFunc.fillDB()
  ServiceFunc.fillCash()
  Cash.postToInstagram()
}
