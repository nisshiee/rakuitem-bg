package controllers

import play.api._
import play.api.mvc._

import rakuitembg.logic._

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def image(keyword: String) = Action {
    Ok(CreateBgImage.byteArray(keyword)) as "image/png"
  }

  def update(keyword: String) = Action {
    val imgBytes = CreateBgImage.byteArray(keyword)
    UpdateTwitterBg(imgBytes)
    Redirect(routes.Application.index)
  }
}
