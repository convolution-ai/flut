import Dependencies._
import sbt.Keys.libraryDependencies

ThisBuild / scalaVersion     := "2.13.2"
ThisBuild / version          := "0.1.0"
ThisBuild / organization     := "com.convolutionai"
ThisBuild / organizationName := "flut"

lazy val root = (project in file("."))
  .settings(
    name := "flut",

    libraryDependencies += scalaTest % Test,
    libraryDependencies += akkaActor,
    libraryDependencies += akkaHttp,
    libraryDependencies += akkaStream,
    libraryDependencies += typesafeConf


  )

