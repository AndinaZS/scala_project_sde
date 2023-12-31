ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.11"

lazy val root = (project in file("."))
  .settings(
    name := "practice_sde"
  )
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.15",
  "org.scalatest" %% "scalatest" % "3.2.15" % "test")