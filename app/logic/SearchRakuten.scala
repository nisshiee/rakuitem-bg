package rakuitembg.logic

import rwsscala._, rwsscala.ichiba._
import scalaz._, Scalaz._

object SearchRakuten {

  def imageUrls(sword: String)(implicit app: ApplicationDetail): List[String] = {
    implicit val https = rwsscala.dispatch.DispatchHttps
    val apiResult = ItemSearch(ItemSearchBase | sword |||, imageFlag = ImageFlag.OnlyHave)
    apiResult ∘ { r: ItemSearchResult =>
      r.items flatMap { i: Item =>
        i.imageStatus match {
          case HasItemImage(_, h :: _) => List(h)
          case _ => List()
        }
      }
    } | List()
  }
}
