name := "scala-training"

version := "0.1"

//scalaVersion := "2.13.6"
scalaVersion := "2.12.14"
libraryDependencies ++= Seq(
//  "org.scalatest" %% "scalatest" % "3.2.9" % "test",
  "org.apache.spark" %% "spark-core" % "3.1.2",
  "org.apache.spark" %% "spark-sql" % "3.1.2"
)

