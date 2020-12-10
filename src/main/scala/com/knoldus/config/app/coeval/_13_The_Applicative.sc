import monix.eval.Coeval


val locationTask: Coeval[String] = Coeval.eval("location")
val phoneTask: Coeval[String] = Coeval.eval("phone")
val addressTask: Coeval[String] = Coeval.eval("address")

// Ordered operations based on flatMap ...
val aggregate = for {
  location <- locationTask
  phone <- phoneTask
  address <- addressTask
} yield {
  location + "_" + phone + "_" + address
}

aggregate.value()

//////////////////// ZIP 3 //////////////////////

val aggregate2 = Coeval.zip3(locationTask, phoneTask, addressTask).map {
    case (location, phone, address) => location + "_" + phone + "_" + address
  }

aggregate2.value()


////////////////// Map3 ////////////////////////

val aggregate3 = Coeval.map3(locationTask, phoneTask, addressTask) {
  (location, phone, address) =>
    location + "_" + phone + "_" + address
}

aggregate3.value()
