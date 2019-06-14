package jorge.arada

import java.util

import ch.qos.logback.classic.spi.{ILoggingEvent, StackTraceElementProxy}
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.ObjectMapper
import net.logstash.logback.composite.AbstractJsonProvider

import scala.util.Try

class MessagingLogsProvider
  extends AbstractJsonProvider[ILoggingEvent] {

  private val objectMapper = new ObjectMapper

  override def writeTo(generator: JsonGenerator, event: ILoggingEvent): Unit = {

    val message: String = event.getMessage
    val throwable = Option(event.getThrowableProxy)
    val jsonMap: Try[util.HashMap[String, AnyRef]] = Try(getMessageAsJson(message))

    val data = jsonMap.getOrElse(new util.HashMap[String, AnyRef]())

    throwable.foreach(
      x => {
        data.put("StackTrace", s"${x.getMessage} \n ${toString(x.getStackTraceElementProxyArray)}")
      }
    )

    val logMessage = new LogDocument(
      jsonMap.map(_ => null).getOrElse(message),
      data
    )

    generator.writeObjectField("Msg", logMessage)
  }

  private def getMessageAsJson(message: String): util.HashMap[String, AnyRef] = {

    objectMapper.readValue(message, classOf[util.HashMap[String, AnyRef]])
  }

  private def toString(stackTraceElementProxyArray: Array[StackTraceElementProxy]): String = {

    val arrayString = stackTraceElementProxyArray.map(x => x.getSTEAsString)
    arrayString.mkString("\n")
  }
}
