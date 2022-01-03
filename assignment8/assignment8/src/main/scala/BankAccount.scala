class BankAccount(private var currentBalance : Double) {
  def this() { this(0) }
  def getBalance = this.currentBalance
  def deposits(amount: Double): Double = {
    if (amount > 0) currentBalance += amount
    else throw new Exception("wrong amount deposit")
    currentBalance
  }

  def withdraw(amount: Double): Double = {
    if (0 < amount && amount <= currentBalance) {
      currentBalance -= amount
    } else throw new Exception("wrong amount withdraw")
    currentBalance
  }
}
