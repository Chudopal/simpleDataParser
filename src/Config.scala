trait Config

case class FileConfig() extends Config

object Config{
  def current: Config = FileConfig()
}
