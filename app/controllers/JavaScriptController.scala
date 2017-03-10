package controllers

import play.Routes
import play.api.routing.JavaScriptReverseRouter

import routes.javascript._

import play.api._
import play.api.mvc._


class JavaScriptController extends Controller{
  def javascriptRoutes = Action { implicit request =>
    Ok(
      JavaScriptReverseRouter("jsRoutes")(
        routes.javascript.CountController.count,
        routes.javascript.HomeController.signUp,
        routes.javascript.HomeController.signIn,
        routes.javascript.HomeController.submit,
        routes.javascript.HomeController.home,
        routes.javascript.HomeController.loginSubmit,
        routes.javascript.HomeController.logout

      )
    ).as("text/javascript")
  }

}