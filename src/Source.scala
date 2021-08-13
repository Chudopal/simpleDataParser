object Source {
  def emit(conf: Config)(): Seq[RawUser] = {
    RawData.generateRawUsers
  }
}
