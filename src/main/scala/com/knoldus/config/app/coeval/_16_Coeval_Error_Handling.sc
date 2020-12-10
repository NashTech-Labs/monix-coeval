import monix.eval.Coeval

import scala.util.{Failure, Random, Success, Try}


val coeval = Coeval(Random.nextInt).flatMap {
  case even if even % 2 == 0 =>
    Coeval.now(even)
  case odd =>
    throw new IllegalStateException(odd.toString)
}

val tryResult: Try[Int] = coeval.runTry

tryResult match {
  case Success(value) => value
  case Failure(exception) => exception
}