object Title

class Document {
  def setTitle(title: String): this.type = {
    this
  }

  def setAuthor(author: String): this.type  = {
    this
  }

  def set(obj: Title.type): this.type = { this }
}

val article = new Document
article.setTitle("Whatever Floats Your Boat").setAuthor("Cay Horstmann") set Title


class Book extends Document {
  def addChapter(chapter: String): this.type  = {
    this
  }
}


val book = new Book()
book.setTitle("Scala for the Impatient").addChapter("chapter1")

