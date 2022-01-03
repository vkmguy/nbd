abstract class Person5(var firstName: String, var lastName: String){
  def taxToPay: Double
}

trait Employee extends Person5 {
  private var salary: Double = _
  def getSalary = this.salary
  def setSalary(salary: Double): Unit = this.salary = salary
  override def taxToPay: Double = this.salary*0.2
}
trait Student extends Person5 {
  override def taxToPay: Double = 0
}
trait Teacher extends Employee {
  override def taxToPay: Double = this.getSalary*0.1
}
