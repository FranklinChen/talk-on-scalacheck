organization := "com.franklinchen"

name := "talk-on-scalacheck"

version := "1.0.0"

scalaVersion := "2.11.2"

libraryDependencies ++= Seq(
  "org.scalacheck" %% "scalacheck" % "1.11.5" % "test",
  "org.specs2" %% "specs2" % "2.4.1" % "test"
)
