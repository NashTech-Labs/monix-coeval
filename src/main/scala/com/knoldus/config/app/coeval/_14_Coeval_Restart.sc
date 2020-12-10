import monix.eval.Coeval

import scala.util.Random

val randomEven = {
  Coeval.eval{
    println("Getting next int..")
    Random.nextInt()
  }.restartUntil(_ % 2 == 0)
}

randomEven.value
