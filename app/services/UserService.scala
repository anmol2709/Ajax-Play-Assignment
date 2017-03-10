package services

import javax.inject.Inject

import models.User
import play.api.cache.CacheApi

import scala.collection.mutable.ListBuffer


class UserService@Inject() (cache: CacheApi) {
  cache.set("list", ListBuffer[User]())
  val userNew = User("Anmol", "anmol", "anmol", "anmol",  "9971783971", "male", 24)
  addUser(userNew)
//  addUser(userNew2)


  def addUser(user: User): Boolean = {
    try {
      val userList: ListBuffer[User] = cache.get[ListBuffer[User]]("list").getOrElse(ListBuffer[User]())
      val encryptedUser = user
      userList.append(encryptedUser)
      cache.set("list", userList)
      true
    }
    catch {
      case e: Exception => false
    }
  }


  def getUser(name: String): User = {
    val userList: ListBuffer[User] = cache.get[ListBuffer[User]]("list").getOrElse(ListBuffer[User]())
    if (userList.filter(x => (x.userName == name)).length == 1) {

      userList.filter(x => (x.userName == name))(0)
    } else
      userNew

  }

  def userExist(name: String): Boolean = {
    val userList: ListBuffer[User] = cache.get[ListBuffer[User]]("list").getOrElse(ListBuffer[User]())

    if (userList.filter(x => (x.userName == name)).length == 1)
      false
    else true
  }

  def checkUser(name: String, password: String): Boolean = {
    val userList: ListBuffer[User] = cache.get[ListBuffer[User]]("list").getOrElse(ListBuffer[User]())
    userList.filter(x => (x.userName == name && x.password == password)).length == 1

  }

  def getList(): ListBuffer[User] = {
    cache.get[ListBuffer[User]]("list").getOrElse(ListBuffer[User]())
  }
}

