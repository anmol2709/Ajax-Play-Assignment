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


//  def submit = Action { implicit request =>
//    val user = User("Anmol", "a", "anmol", "anmol",  "9971783971", "male", 24)
//    //    val user1: User = formControl.userForm.bindFromRequest.get
//    //     print(user1)
//
//      }

  def loginSubmit = Action { implicit request =>
//      val userLogin: Login = formControl.loginForm.bindFromRequest.get
      val userLogin=Login("anmol","anmol")
      if (service.checkUser(userLogin.userName, userLogin.password)) {
        val foundUser = service.getUser(userLogin.userName)
        Ok(views.html.profile(foundUser)).withSession("connected" -> userLogin.userName)
      }
      else {
       Ok("Unable to login")
      }
    }

  def submit(name:String, userName:String, password: String, verifyPassword:String, mobileNumber:String, gender:String, age: Int)=Action { implicit request =>

      val user = User(name,userName, password,verifyPassword,mobileNumber,gender,age)
    if(service.userExist(user.userName)) {
      service.addUser(user)
      Ok(views.html.profile(user)).withSession("connected" -> user.userName)
    }else {
        Ok(views.html.signUp())
      }
    }



}


