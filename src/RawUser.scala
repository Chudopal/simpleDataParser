case class RawUser(
                    fullName: String,
                    email: String,
                    phone: String,
                    streetAddress: String,
                    city: String,
                    zipCode: String) {
  lazy val person: Either[TransformError, Person] = {
    fullName.split(" ").toList match {
      case first :: last :: Nil => Right(Person(first, last))
      case _ => Left(TransformError(s"Failing parsing person"))
    }
  }
}
