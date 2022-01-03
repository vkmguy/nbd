object Assignment9 {

  def main(args: Array[String]): Unit = {
    val container: Container[String] = new Container[String]("John")

    println("\ntask1 Results: \n" + container.applyFunction(reverseString))
    val yes: Yes[String] = new Yes[String]("Doe")
    val no: No = new No()

    println("\ntask2 Results: ")
    println("check no is instance: " + no.isInstanceOf[Maybe[_]])
    println("check yes is instance: " + yes.isInstanceOf[Maybe[_]])

    println("\ntask3 Results: ")
    val yes1: Yes[String] = yes.applyFunction(reverseString)
    println("yes Result : " + yes1.getValue)
    println("yes type : " + yes1.isInstanceOf[Yes[_]])
    val no1: No = no.applyFunction(reverseString)
    println("no type : " + no1.isInstanceOf[No])

    println("\ntask4 Results")
    println("yes Result : " + yes.getOrElse("test Data"))
    println("no Result : " + no.getOrElse("Test Data"))
  }

  class Container[A](private val value: A) {
    def getValue: A = {
      value
    }

    def applyFunction[R](f: A => R): R = {
      f(value)
    }
  }

  trait Maybe[A] {
    def applyFunction[R](f: A => R): Maybe[_]

    def getOrElse[B >: A](v: B): B
  }

  class No extends Maybe[Nothing] {
    override def applyFunction[R](f: Nothing => R): No = {
      new No()
    }

    override def getOrElse[B](value: B): B = {
      value
    }
  }

  class Yes[A](var value: A) extends Maybe[A] {
    def getValue: A = {
      value
    }

    override def applyFunction[R](f: A => R): Yes[R] = {
      new Yes[R](f(getValue))
    }

    override def getOrElse[B >: A](value: B): B = {
      getValue
    }
  }

  object reverseString extends (String => String) {
    def apply(str: String): String = {
      str.reverse
    }
  }
}
