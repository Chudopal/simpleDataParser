object PhoneNumber {
  private val pattern = """(\d)-(\d{3})-(\d{3})-(\d{4})""".r

  def from(phoneString: String): PhoneNumber = ???
}

case class PhoneNumber(
    countryCode: Int,
    areaCode: Int,
    prefix: Int,
    lineNumber: Int) {
  override def toString = s"$countryCode ($areaCode) $prefix-$lineNumber"
}
