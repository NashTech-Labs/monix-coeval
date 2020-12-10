package com.knoldus.config.app

// On evaluation a Scheduler is needed

import monix.execution.Scheduler.Implicits.global

import scala.concurrent.Future
import scala.util.Random
// For Task
// For Observable


object SampleApplicationWithTaskNow /*extends App*/ {

  def average(students: List[Student], i: Int): Int = {
    Thread.sleep(2000) // Wait time 2 seconds
    val average = students.map(_.marks).sum / students.size
    println(s"===> Calculated average = $average with id : $i")
    average
  }

  def averageFuture(students: List[Student], i: Int): Future[Int] = Future {
    Thread.sleep(2000) // Wait time 2 seconds
    val average = students.map(_.marks).sum / students.size
    println(s"===> Calculated average = $average with id : $i")
    average
  }

  def students: List[Student] = (0 until 100).map { rollNo =>
    Student(rollNo, Random.nextInt(100))
  }.toList

  /*println("\nTask.now...")
  val averageMarksTaskNow: Task[Int] = Task.now(average(students, 1))


  println("\nTask...")
  val averageMarksTask: Task[Int] = Task(average(students, 2))


  println("\nTask.eval...")
  val averageMarksTaskEval: Task[Int] = Task.eval(average(students, 3))

  averageMarksTaskEval.runToFuture.foreach(println)
  averageMarksTaskEval.runToFuture.foreach(println)*/


  /*  println("\nTask.evalOnce...")
    val averageMarksTaskEvalOnce: Task[Int] = Task.evalOnce(average(students, 4))

    averageMarksTaskEvalOnce.runToFuture.foreach(println)
    averageMarksTaskEvalOnce.runToFuture.foreach(println)*/

  /* println("\nTask.defer...")

   val task = Task.defer{
     Task.now(average(students, 5))
   }

   task.runToFuture.foreach(println)
   task.runToFuture.foreach(println)*/

  /*println("Task.fromFuture...")
  private val futureAverage: Future[Int] = Future(average(students, 6))

  val futureToTask: Task[Int] = Task.fromFuture(futureAverage)

  futureToTask.foreach(println)*/


  /*
  println("Task.defer(future)")
  val taskfromFuture = Task.defer{
    val futureRes = Future(average(students, 7))
    Task.fromFuture(futureRes)
  }

  taskfromFuture.foreach(println)*/

  /*println("Task.deferFuture")

  val taskDeferFuture = Task.deferFuture{
    Future(average(students, 8))
  }

  taskDeferFuture.foreach(println)*/


  /*println("Task.deferFutureAction")

  def sumTask(list: List[Student])(implicit ec: ExecutionContext): Task[Int] ={
    Task.deferFutureAction(averageFuture(list, 12))
  }

  val task = sumTask(students)

  task.foreach(println)*/
}
