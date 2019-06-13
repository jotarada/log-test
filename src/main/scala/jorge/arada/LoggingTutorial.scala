package jorge.arada

import org.slf4j.LoggerFactory

object LoggingTutorial
  extends App {

  private val logger = LoggerFactory.getLogger(this.getClass)

  val a = new Exception("Este erro")

  val json =

    """{"Alfaces": {"esta_key":"este value"}}"""

  logger.info(json,a)

  //logger.info("Hello there!")

  /* logger.debug("Hello there!")
   logger.error("Hello there!")
   logger.warn("Hello there!")
   logger.trace("Hello there!")
 */


  /*logger.info("Este erro", a)*/
}
