import com.sun.org.apache.xerces.internal.impl.dv.xs.DayDV

import java.util.OptionalInt
import scala.annotation.tailrec

object Assignment7 {
  val  days = List("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
  val products = Map("Car" -> 250.0, "Bicycle" -> 500.0, "Motorcycle" -> 1000.0)
  val productsDouble = Map("Car" -> Option(250.0), "Bicycle" -> Option(500.0), "Motorcycle" -> Option(1000.0))

  def task1a(): String ={
    var result = ""
      for(day <- days)
        result += day + ","
    result.substring(0, result.length-1)
  }

  def task1b(): String ={
    var result = ""
    for(day <- days if day.toLowerCase.startsWith("s"))
      result += day + ","
    result.substring(0, result.length-1)
  }

  def task1c(): String ={
    var result = ""
    val index: Int = 0
    while(index < 7)
      result += days(index) + ","
    result.substring(0, result.length-1)
  }

  def task2a(task2aList: List[String]): String ={
    if(task2aList.tail.isEmpty)
      return task2aList.head
    task2aList.head + "," + task2a(task2aList.tail)
  }

  def task2b(task2bList: List[String]): String ={
    if(task2bList.tail.isEmpty)
      return task2bList.head
    task2b(task2bList.tail) + "," + task2bList.head
  }

  @tailrec
  def task3(task3List: List[String], str: String): String ={
    if(task3List.tail.isEmpty)
      return str+task3List.head
    task3(task3List.tail, str + task3List.head + ",")
  }

  def task4a(): String ={
    var result = days.foldLeft("")(_ + _ + ", ")
    result.substring(0, result.length-2)
  }

  def task4b(): String ={
    var result = days.foldRight("")(_ + ", " + _)
    result.substring(0, result.length-2)
  }

  def task4c(): String ={
    var result = days.foldRight("") { (next, sum) => if (next.toLowerCase.startsWith("s")) next + ", " + sum else sum }
    result.substring(0, result.length-2)
  }

  def task5(map: Map[String, Double] ): Map[String, Double] = map.transform((k, v) => v - v * 0.1)

  def task6(list: List[Int]): List[Int] = list.map(n => n+1)

  def task7(list: List[Double]): List[Double] = list.filter(-5 < _).filter(_ < 12).map(_.abs)

  def task8(tuple: (Int, String, Double)): Unit = println(tuple._1 + " " + tuple._2 + " " + tuple._3 + " ")

  def task9(list: List[Int]): List[Int] = {
    if (list.isEmpty) list
    else if (list.head == 0) task9(list.tail)
    else list.head :: task9(list.tail)
  }

  def task10(map: Map[String, Option[Double]]): Map[String, Double] = {
    map.filter(p => p._2.isDefined).transform((k, v) => {
      v.get - v.get * 0.1
    })
  }

  def main(args: Array[String]): Unit = {
    // task 1
    println(task1a())
    println(task1b())
    println(task1c())

    //task 2
    println(task2a(days))
    println(task2b(days))

    //task 3
    println(task3(days, ""))

    //task 4
    println(task4a())
    println(task4b())
    println(task4c())

    //task 5
    println(task5(products))

    //task 6
    println(task6(List(1, 2, 3, 4, 5)))

    //task 7
    println(task7(List(-10.0, -1.2, 1.4, 10.5, 12.9)))

    //task 8
    println(task8(Tuple3(1,"name",125.68)))

    //task 9
    println(task9(List(2, 3, 5, 0, 10)))

    //task 10
    println(task10(productsDouble))
  }
}
