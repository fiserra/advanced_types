
//A type alias must be nested inside a class or object.
//It cannot appear at the top level of a Scala file
class Book {
  import scala.collection.mutable._
  type Index = HashMap[String, (Int, Int)]
}