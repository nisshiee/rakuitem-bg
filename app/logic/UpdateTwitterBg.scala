package rakuitembg.logic

import twitter4j._
import java.io.ByteArrayInputStream

object UpdateTwitterBg {

  def apply(imgBytes: Array[Byte]) = {
    val twi = TwitterFactory.getSingleton
    val in = new ByteArrayInputStream(imgBytes)
    val user = twi.updateProfileBackgroundImage(in, true)
  }

}
