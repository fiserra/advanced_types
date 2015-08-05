import scala.collection.mutable.ArrayBuffer
class Network {
  class Member(val name: String) {
    val contacts = new ArrayBuffer[Network#Member] //a Member of any Network
  }
  private val members = new ArrayBuffer[Member]
  def join(name: String) = {
    val m = new Member(name)
    members += m
    m
  }
}

val chatter = new Network
val myFace = new Network


val fred = chatter.join("Fred") // Has type chatter.Member
val barney = myFace.join("Barney") // Has type myFace.Member
fred.contacts += barney