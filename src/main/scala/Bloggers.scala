trait TikTok{
  def postToTikTok(message:String):Unit
}

trait Instagram {
  def postToInstagram(message:String):Unit
}

abstract protected class Blogger{
  def id:String
}

case class InstaBlogger(id: String) extends Blogger with Instagram{
  override def postToInstagram(message: String): Unit = println(s"$id send '$message' to Instagram")
}

case class TikTokBlogger(id: String) extends Blogger with TikTok {
  override def postToTikTok(message: String): Unit = println(s"$id send '$message' to TikTok")
}

case class MixedBlogger(id: String) extends Blogger with Instagram with TikTok{
  override def postToInstagram(message: String): Unit = println(s"$id send '$message' to Instagram")
  override def postToTikTok(message: String): Unit = println(s"$id send '$message' to TikTok")
}