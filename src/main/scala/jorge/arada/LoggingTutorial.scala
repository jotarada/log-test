package jorge.arada

import org.slf4j.LoggerFactory

object LoggingTutorial
  extends App {

  private val logger = LoggerFactory.getLogger(this.getClass)

  val a = new Exception("Este erro")
  //throw new Exception("Este erro é o 2o")

  val json =

    """{"Alfaces": {"esta_key":"este value"}}"""

  //logger.info(json,a)

  logger.info("Hello there!",a)

  /* logger.debug("Hello there!")
   logger.error("Hello there!")
   logger.warn("Hello there!")
   logger.trace("Hello there!")
 */


  /*logger.info("Este erro", a)*/
}
