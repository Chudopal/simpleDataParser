case class RawUser(
    fullName: String,
    email: String,
    phone: String,
    streetAddress: String,
    city: String,
    zipCode: String) {
  lazy val person: Person = ???
}
