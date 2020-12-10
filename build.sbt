name := "monix-ground"

version := "1.0"

scalaVersion := "2.11.11"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.4",
  "com.github.pureconfig" %% "pureconfig" % "0.13.0",
  "io.monix" %% "monix" % "3.2.2",
  "io.monix" %% "monix-execution" % "3.2.2",
  "io.monix" %% "monix-catnap" % "3.2.2",
  "io.monix" %% "monix-eval" % "3.2.2",
  "io.monix" %% "monix-reactive" % "3.2.2",
  "io.monix" %% "monix-tail" % "3.2.2"
)
