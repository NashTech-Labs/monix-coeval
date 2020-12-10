package com.knoldus.config.app

import monix.eval.Coeval
import monix.execution.Scheduler.Implicits.global

import scala.concurrent.Future
import scala.util.{Failure, Random, Success}

object CoevalSample extends App {

  def average(students: List[Student], i: Int): Int = {
    Thread.sleep(2000) // Wait time 2 seconds
    val average = students.map(_.marks).sum / students.size
    println(s"===> Calculated average = $average with id : $i")
    average
  }

  def averageFuture(students: List[Student], i: Int): Future[Int] = Future{
    Thread.sleep(2000) // Wait time 2 seconds
    val average = students.map(_.marks).sum / students.size
    println(s"===> Calculated average = $average with id : $i")
    average
  }

  def students: List[Student] = (0 until 100).map{ rollNo =>
    Student(rollNo, Random.nextInt(100))
  }.toList

  val averageCoeval = Coeval.eval(average(students, 1))

  val averageCoevalValue = averageCoeval.value()
  val averageCoevalValue1 = averageCoeval.value()
  val averageCoevalValue2 = averageCoeval.value()

  println("Value.... : " + averageCoevalValue)
  println("Value.... : " + averageCoevalValue1)
  println("Value.... : " + averageCoevalValue2)

  val averageCoevalTryResult = averageCoeval.runTry match{
    case Success(value) => value
    case Failure(exception) => throw exception
  }

  println("Average coeval try result... : " + averageCoevalTryResult)

}
