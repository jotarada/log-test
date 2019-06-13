package jorge.arada

import java.util

import ch.qos.logback.classic.spi.ILoggingEvent
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.ObjectMapper
import net.logstash.logback.composite.AbstractJsonProvider

import scala.util.Try

class MessagingLogsProvider
  extends AbstractJsonProvider[ILoggingEvent] {

  private val objectMapper = new ObjectMapper

  override def writeTo(generator: JsonGenerator, event: ILoggingEvent): Unit = {

    val message: String = event.getMessage
    val throwable = event.getThrowableProxy
    val jsonMap: util.HashMap[String, Any] = Try(getMessageAsJson(message)).getOrElse(new util.HashMap[String, Any]())
    val stackStrace = Try(throwable.getMessage).getOrElse(null)

    val logMessage = createLogMessage(jsonMap, stackStrace, message)
    val a = new util.HashMap[String, Any]()
    a.put("Message",logMessage.message.getOrElse(null))
    a.put("Data",logMessage.data)

    generator.writeObjectField("Msg", a)
  }

  private def getMessageAsJson(message: String): util.HashMap[String, Any] = {

    objectMapper.readValue(message, classOf[util.HashMap[String, Any]])
  }

  private def createLogMessage(jsonMap: util.HashMap[String, Any], stackStrace: String, message: String): LogDocument = {

    if(!jsonMap.isEmpty) {
      if(stackStrace != null) {
        jsonMap.put("StackTrace", stackStrace)
      }

      new LogDocument(
        message = None,
        data = jsonMap
      )
    }
    else {
      if(stackStrace != null) {
        jsonMap.put("StackTrace", stackStrace)
      }

      new LogDocument(
        message = Some(message),
        data = jsonMap
      )
    }
  }
}
