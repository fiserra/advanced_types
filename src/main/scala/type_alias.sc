
//A type alias must be nested inside a class or object.
//It cannot appear at the top level of a Scala file
class Book {

  import scala.collection.mutable._

  type Index = HashMap[String, (Int, Int)]
}


type Whole = Int
val x: Whole = 5

type UserInfo = Tuple2[Int, String]
val u: UserInfo = new UserInfo(123, "George")

type T3[A, B, C] = Tuple3[A, B, C]

val things = new T3(1, 'a', true)
type Mappy[A,B] = collection.mutable.HashMap[A,B]
