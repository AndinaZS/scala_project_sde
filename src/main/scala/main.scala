object main extends App {
  val NUMBER_TIKTOK_BLOGGERS: Int = 5
  val NUMBER_INSTA_BLOGGERS: Int = 5
  val NUMBER_MIXED_BLOGGERS: Int = 5



  ServiceFunc.createAccounts("instagram", NUMBER_INSTA_BLOGGERS)
  ServiceFunc.createAccounts("tiktok", NUMBER_TIKTOK_BLOGGERS)
  ServiceFunc.createAccounts("mix", NUMBER_MIXED_BLOGGERS)
  ServiceFunc.fillCash()
  Cash.postToInstagram()
}
