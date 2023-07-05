//класс Blogger, определяет основные поля и метод post для блоггеров, ведущих определенные соцсети.
//id - идентификатор блогера
//allowedSocialNetwork - строковый массив для определения соцсетей, которые ведет блогер

abstract class Blogger {
  val id: String
  val allowedSocialNetwork: Array[String]

  def post(message: String, socialNetwork: String): Unit = socialNetwork match {
    case socialNetwork if allowedSocialNetwork.contains(socialNetwork) =>
      println(s"$id send '$message' to $socialNetwork")
    case _ => println(s"not allowed")
  }

}

//класс учетной записи Instagram блоггера
case class InstaBlogger(id: String) extends Blogger {
  val allowedSocialNetwork: Array[String] = Array("instagram")
}

//класс учетной записи TikTok блоггера
case class TikTokBlogger(id: String) extends Blogger {
  val allowedSocialNetwork: Array[String] = Array("tiktok")
}

//класс учетной записи Instagram TikTok блоггера
case class Mixed(id: String) extends Blogger {
  val allowedSocialNetwork: Array[String] = Array("instagram", "tiktok")
}
