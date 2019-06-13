package jorge.arada

case class LogDocument (
  msg: LogElement
)

case class LogElement(
  message: Option[String],
  data: Map[String,Any]
)
