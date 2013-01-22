package rakuitembg.logic

import rwsscala._, rwsscala.ichiba._
import play.api.Play
import scalaz._, Scalaz._

object CreateBgImage {

  def apply(sword: String) = {
    import Play.current
    implicit val app = ApplicationDetail(Play.configuration.getString("rakuitembg.rws.applicationId") | "")
    val urls = SearchRakuten.imageUrls(sword)
    val imgs = urls map { url: String =>
      val img = ImageProcessing.load(url)
      ImageProcessing.brighten(img)
    }
    ImageProcessing.tileImage(imgs)
  }

  def byteArray(sword: String) =
    ImageProcessing.byteArray(apply(sword))
}
