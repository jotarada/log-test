package jorge.arada

import java.util.UUID

import ch.qos.logback.core.spi.DeferredProcessingAware
import com.fasterxml.jackson.core.JsonGenerator
import net.logstash.logback.composite.ContextJsonProvider
import org.slf4j.MDC

class Uuid
  extends ContextJsonProvider[DeferredProcessingAware] {

  private val UUID_DEFAULT_FIELD_NAME: String = "ActId"

  setFieldName(UUID_DEFAULT_FIELD_NAME)

  override def writeTo(generator: JsonGenerator, event: DeferredProcessingAware): Unit = {

    val uuid: String = Option(MDC.get(getFieldName)).getOrElse(UUID.randomUUID.toString)
    generator.writeStringField(getFieldName, uuid)
  }
}
