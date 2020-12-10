import monix.eval.Coeval


def isGreater(a: Int, b: Int): Coeval[Boolean] = {
  println("Function called..")
  Coeval.eval(a < b).flatMap {
    case true =>
      println("Returning true")
      Coeval.now(true)
    case false =>
      println("Returning true")
      Coeval.now(false)
  }
}

val result = isGreater(2, 3)

result.value()
