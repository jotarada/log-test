package jorge.arada

import org.slf4j.LoggerFactory

object LoggingTutorial
  extends App {

  //setDefaultUncaughtExceptionHandler()

  private val logger = LoggerFactory.getLogger(this.getClass)

  val a = new Exception("Este erro")
  //throw new Exception("Este erro é o 2o")

  val json =

    """{"Alfaces": {"esta_key":"este value"}}"""

  logger.info(json,a)

  //logger.info("Hello there!",a)

  /* logger.debug("Hello there!")
   logger.error("Hello there!")
   logger.warn("Hello there!")
   logger.trace("Hello there!")
 */

  /*logger.info("Este erro", a)*/

/*  def setDefaultUncaughtExceptionHandler(): Unit = {

    try {
      Thread.setDefaultUncaughtExceptionHandler(
        (t: Thread, e: Throwable) => {
          e match {
            case
              a: Exception => logger.error("Uncaught Exception detected in thread " + t, a)
          }
        }
      )
    }
    catch {
      case e: SecurityException =>
        logger.error("Could not set the Default Uncaught Exception Handler", e)
    }
  }*/
}


