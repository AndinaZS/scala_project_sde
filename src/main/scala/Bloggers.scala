trait Post{
  def post(message: String, socialNetwork: String): Unit
}
abstract protected class Blogger extends Post {
  val id: String
  val allowedSocialNetwork: Array[String]

  override def post(message: String, socialNetwork: String): Unit = socialNetwork match {
    case socialNetwork if allowedSocialNetwork.contains(socialNetwork) =>
      println(s"$id send '$message' to $socialNetwork")
    case _ => println(s"not allowed")
  }
}

case class InstaBlogger(id: String) extends Blogger  {
  val allowedSocialNetwork: Array[String] = Array("instagram")
}

case class TikTokBlogger(id: String) extends Blogger {
  val allowedSocialNetwork: Array[String] = Array("tiktok")
}

case class Mixed(id: String) extends Blogger {
  val allowedSocialNetwork: Array[String] = Array("instagram", "tiktok")
}
