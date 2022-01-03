case class Person(var firstName: String, var lastName: String) {
  def greet: Unit = this match {
    case Person(first, second) => println(s"Welcome ${first} ${second}")
    case Person(first, _)  => println(s"Hello ${first}")
    case Person(_, second) => println(s"Hello Mr ${second}")
  }
}