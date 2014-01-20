organization := "com.franklinchen"

name := "talk-on-scalacheck"

version := "1.0.0"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
  "org.scalacheck" %% "scalacheck" % "1.11.2" % "test",
  "org.specs2" %% "specs2" % "2.3.7" % "test"
)
