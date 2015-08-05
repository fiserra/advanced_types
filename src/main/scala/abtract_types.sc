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