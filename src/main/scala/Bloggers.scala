//класс Blogger, определяет основные поля и метод post для блоггеров, ведущих определенные соцсети.
//id - идентификатор блогера
//allowedSocialNetwork - строковый массив для определения соцсетей, которые ведет блогер

abstract class Blogger {
  val id: String
  val allowedSocialNetwork: Array[String]
}

trait Post extends Blogger {
  def post(message: String, socialNetwork: String): Unit
  = socialNetwork match {
    case socialNetwork if allowedSocialNetwork.contains(socialNetwork) =>
      println(s"$id send '$message' to $socialNetwork")
    case _ => println(s"not allowed")
  }
}
  //класс учетной записи Instagram блоггера
  case class InstaBlogger(id: String) extends Post {
    val allowedSocialNetwork: Array[String] = Array("instagram")
    override def post(message: String, socialNetwork: String): Unit = super.post(message, socialNetwork)
  }

  //класс учетной записи TikTok блоггера
  case class TikTokBlogger(id: String) extends Post {
    val allowedSocialNetwork: Array[String] = Array("tiktok")
    override def post(message: String, socialNetwork: String): Unit = super.post(message, socialNetwork)
  }

  //класс учетной записи Instagram TikTok блоггера
  case class Mixed(id: String) extends Post {
    val allowedSocialNetwork: Array[String] = Array("instagram", "tiktok")
    override def post(message: String, socialNetwork: String): Unit = super.post(message, socialNetwork)
  }
