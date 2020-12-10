import monix.eval.Coeval

import scala.annotation.tailrec

// Calculate the N-th number in the Fibonacci sequence
@tailrec
def fib(cycles: Int, a: BigInt = 0, b: BigInt = 1): BigInt = {
  if (cycles < 0) {
      b
  } else {
      fib(cycles-1, b, a + b)
  }
}

def fibM(cycles: Int, a: BigInt = 0, b: BigInt = 1): Coeval[BigInt] = {
  if (cycles < 0) {
      Coeval.now(b)
  } else {
      Coeval.defer(Coeval(fib(cycles-1, b, a+b)))
  }
}

fib(4)
fibM(4).value()
