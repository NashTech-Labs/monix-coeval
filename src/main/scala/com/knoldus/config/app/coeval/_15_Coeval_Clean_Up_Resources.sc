import monix.eval.Coeval

val coeval = Coeval(1)

val withFinishCb: Coeval[Int] = coeval.doOnFinish {
  case None =>
    println("Was success!")
    Coeval.unit
  case Some(ex) =>
    println(s"Had failure: $ex")
    Coeval.unit
}

withFinishCb.value
