import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

import scala.io.Source

trait Reader {
  type In
  type Contents

  def read(in: In): Contents
}

class StringReader extends Reader {
  type Contents = String
  type In = String

  def read(fileName: String) = Source.fromFile(fileName, "UTF-8").mkString
}

class ImageReader extends Reader {
  type Contents = BufferedImage
  type In = File

  def read(file: File) = ImageIO.read(file)
}

//======================================================
class BaseUser(name: String)

class Admin(name: String, val level: String) extends BaseUser(name)

class Customer(name: String) extends BaseUser(name)

abstract class Card {
  type UserType <: BaseUser

  def verify(u: UserType): Boolean
}


class SecurityCard extends Card {
  type UserType = Admin

  def verify(u: Admin) = true
}

val v1 = new SecurityCard().verify(new Admin("George", "high"))

class GiftCard extends Card {
  type UserType = Customer

  def verify(u: Customer) = true
}

val v2 = new GiftCard().verify(new Customer("Fred"))

//======================================================

class User(val name: String)

trait Factory {
  type A
  def create: A
}

trait UserFactory extends Factory {
  type A = User

  def create = new User("")
}

trait Factory2[A] { def create: A }
trait UserFactory2 extends Factory[User] { def create = new User("") }