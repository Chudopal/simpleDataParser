object Main {
  def main(args: Array[String]): Unit = {
    val emitRecords: () => Seq[RawUser] = Source.emit(Config.current)
  }

  private def go(emit: () => Seq[RawUser]): Result = ???

  private def toResult(v: DomainUser): Result = ???

  private def transform(r: RawUser): Either[TransformError, DomainUser] = {
    val maybePerson: Either[TransformError, Person] = r.person
    val maybePhone: Either[TransformError, PhoneNumber] = PhoneNumber.from(r.phone)
    for {
      person <- maybePerson
      phone <- maybePhone
    } yield DomainUser(person, phone)
  }
}
