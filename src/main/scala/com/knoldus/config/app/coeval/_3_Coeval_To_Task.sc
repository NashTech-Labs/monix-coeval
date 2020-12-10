import com.knoldus.config.app.Student
import monix.eval.{Coeval, Task}
import monix.execution.CancelableFuture
import monix.execution.Scheduler.Implicits.global

import scala.util.Random


def average(students: List[Student]): Int = {
  println("Evaluating....\n")
  val average = students.map(_.marks).sum / students.size
  average
}

def students: List[Student] = (0 until 100).map{ rollNo =>
  Student(rollNo, Random.nextInt(100))
}.toList

val averageCoeval = Coeval(average(students))

// To Task conversion
val averageTask: Task[Int] = averageCoeval.to[Task]

val result: CancelableFuture[Int] = averageTask.runToFuture
