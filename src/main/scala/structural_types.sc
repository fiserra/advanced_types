def appendLines(target: {def append(str: String): Any}, lines: Iterable[String]) {
  for (l <- lines) {
    target.append(l); target.append("\n")
  }
}

/**
 * A reflective call is much more expensive than a regular method call. For that reason, you
 * should only use structural typing when you model common behavior from classes that cannot share a
 * trait.
 *
 * Structural types are similar to “duck typing” in dynamically typed programming languages
 */


def process(target: {def close(): Unit}, func: Any => Unit): Unit = {

  try {
    func(target)
  }
  finally {
    target.close()
  }
}


object YourLibrary {
  // this is a type alias for the structural type

  type Closeable = {
    def close(): Unit
  }

  // now use ': Closeable' like regular syntax, but its still

  // a structural "anything that has close on it" type

  def doClose(closeable: Closeable) = {
    // other nifty stuff
    closeable.close()
  }
}


// wrong!
def foo(a: { def bar(a: Int, b: Int): String; val baz: List[String => String] }) = {

}
// right!
private type FooParam = {
  val baz: List[String => String]
  def bar(a: Int, b: Int): String
}