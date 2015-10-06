name := "talk-on-scalacheck"

organization := "com.franklinchen"

organizationHomepage := Some(url("http://franklinchen.com/"))

homepage := Some(url("http://github.com/FranklinChen/talk-on-scalacheck"))

startYear := Some(2013)

description := "Talk on ScalaCheck given at Pittsburgh Scala in 2013"

version := "1.0.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.scalacheck" %% "scalacheck" % "1.12.5" % Test,
  "org.specs2" %% "specs2-core" % "3.6.4" % Test,
  "org.specs2" %% "specs2-scalacheck" % "3.6.4" % Test
)

resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"
