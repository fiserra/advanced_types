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
