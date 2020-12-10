import com.knoldus.config.app.Student
import monix.eval.Coeval
import scala.util.{Success, Failure}
import scala.util.Random


def average(students: List[Student]): Int = {
  println("Evaluating....\n")
  val average = students.map(_.marks).sum / students.size
  average
}

def students: List[Student] = (0 until 100).map{ rollNo =>
  Student(rollNo, Random.nextInt(100))
}.toList


// **** Coeval declaration *******

val coeval = Coeval(average(students))

// Coeval has lazy behavior, so nothing
// happens until being evaluated:
coeval.value


// ***** Coeval with exception *******

val coevalWithExp = Coeval{
  throw new Exception("Test exception")
}

// And we can handle errors explicitly:
coevalWithExp.runTry match {
  case Success(value) =>
    println("Got value : " + value)
  case Failure(ex) =>
    println("Got error : " + ex)
}
