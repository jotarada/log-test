package jorge.arada

class LogDocument(
  val message: Option[String],
  val data: java.util.HashMap[String, Any]
)
  extends Serializable