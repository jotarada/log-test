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

    if(!jsonMap.isEmpty) {
      if(throwable != null) {

        val stackTrace = throwable.getMessage

        checkForData(jsonMap).put("StackTrace", stackTrace)
      }
    }
    else {
    }
    generator.writeObjectField("Msg", jsonData)
  }

  private def checkForData(jsonMap: util.HashMap[String, Any]): util.HashMap[String, Any] = {

    if(jsonMap.containsKey("Data")) {

      jsonMap.get("Data").asInstanceOf[util.HashMap[String, Any]]
    }
    else {
      jsonMap
    }
  }

  private def getMessageAsJson(message: String): util.HashMap[String, Any] = {

    objectMapper.readValue(message, classOf[util.HashMap[String, Any]])
  }
}
