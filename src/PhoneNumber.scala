import scala.util.Try

object PhoneNumber {
  private val pattern = """(\d)-(\d{3})-(\d{3})-(\d{4})""".r

  private def toInt(s: String): Either[TransformError, Int] = {
    Try(s.toInt).toEither.left.map(e => TransformError(e.getMessage))
  }

  def from(phoneString: String): Either[TransformError, PhoneNumber] = {
    phoneString match {
      case pattern(code, area, prefix, line) => {
        for {
          codeNum <- toInt(code)
          areaNum <- toInt(area)
          prefixNun <- toInt(prefix)
          lineNum <- toInt(line)
        } yield PhoneNumber(codeNum, areaNum, prefixNun, lineNum)
      }
      case _ => Left(TransformError(s"$phoneString didn't parse"))
    }
  }
}

case class PhoneNumber(
                        countryCode: Int,
                        areaCode: Int,
                        prefix: Int,
                        lineNumber: Int) {
  override def toString = s"$countryCode ($areaCode) $prefix-$lineNumber"
}
