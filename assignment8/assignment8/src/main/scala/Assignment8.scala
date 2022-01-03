object Assignment8 {
  val weekDays = List("Monday", "Tuesday", "Wednesday", "Thursday", "Friday")
  val weekEnds = List( "Saturday", "Sunday")
  object task1 extends (String => String) {
    def apply(day: String): String = {
      val workDay = "work"
      val weekendDay = "weekend"
      val noSuchADay = "no such day"
      day match {
        case wd if weekDays.contains(wd) => workDay
        case we if weekEnds.contains(we) => weekendDay
        case _ => noSuchADay
      }
    }
  }
  def task4(input: Int, operation: Int => Int): Int = operation(operation(operation(input)))

  def main(args: Array[String]): Unit = {
    println("\nTask1: Results")
    println(task1("Sunday"))
    println(task1("Monday"))
    println(task1("none"))
    println("\nTask2: Results")
    val bank = new BankAccount()
    bank.deposits(100.0)
    bank.withdraw(20)
    println(bank.getBalance)
    var bank2 = new BankAccount(100.0)
    println(bank2.getBalance)
    println("\nTask3: Results")
    val john: Person = new Person("John", "Doe")
    john.greet

    val emptyJohn: Person = new Person(null, "Doe")
    emptyJohn.greet

    val emptyDoe: Person = new Person("John", null)
    emptyDoe.greet

    println("\nTask4: Results")
    println(task4(4, x => x*x))
    println("\nTask5:")
    object emp1 extends Person5("John", "Doe") with Employee
    emp1.setSalary(100)
    println(emp1.taxToPay)
    object stud1 extends Person5("John", "Doe") with Student
    println(stud1.taxToPay)
    object tech1 extends Person5("John", "Doe") with Teacher
    tech1.setSalary(100)
    println(tech1.taxToPay)
    object emp2 extends Person5("John", "Doe") with Student with Employee
    emp2.setSalary(500)
    println(emp2.taxToPay)
    object stud2 extends Person5("John", "Doe") with Employee with Student
    stud2.setSalary(100)
    println(stud2.taxToPay)
    object tech2 extends Person5("John", "Doe") with Employee with Teacher
    tech2.setSalary(100)
    println(tech2.taxToPay)
    object stud3 extends Person5("John", "Doe") with Teacher with Student
    stud3.setSalary(100)
    println(stud3.taxToPay)
  }
}
