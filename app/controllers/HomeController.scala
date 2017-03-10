package controllers

import javax.inject._
import models.{Login, User}
import play.api._
import play.api.mvc._
import services.UserService


@Singleton
class HomeController @Inject()(service:UserService,formControl:FormController) extends Controller {

  def welcome=Action {
    Ok(views.html.main("")(views.html.welcome()))
  }

  def signUp=Action {
    Ok(views.html.signUp())
  }

  def signIn=Action {
    Ok(views.html.login())
  }

  def logout=Action {
    Ok(views.html.welcome()).withNewSession
  }



  def loginSubmit(userName: String) = Action { implicit request =>

    val userLogin=service.getUser(userName)
println(userLogin.userName)
      if (service.checkUser(userLogin.userName, userLogin.password)) {

        Ok(views.html.profile(userLogin)).withSession("connected" -> userLogin.userName)
      }
      else {
       Ok(views.html.login()).withNewSession
      }
    }

  def submit(name:String, userName:String, password: String, verifyPassword:String, mobileNumber:String, gender:String, age: Int)=Action { implicit request =>

      val user = User(name,userName, password,verifyPassword,mobileNumber,gender,age)
    if(service.userExist(user.userName)) {
      service.addUser(user)
      Ok(views.html.profile(user)).withSession("connected" -> user.userName)
    }else {
        Ok("UserName Already Exists")
      }
    }


  def home=Action{implicit request =>
    Ok(views.html.welcome())
  }


}


