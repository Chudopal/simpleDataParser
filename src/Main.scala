object Main {
  def main(args: Array[String]): Unit = ???
  private def go(emit: () => Seq[RawUser]): Result = ???
  private def toResult(v: DomainUser): Result = ???
  private def transform(r: RawUser): DomainUser = ???
}
