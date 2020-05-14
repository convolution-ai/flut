import sbt._

object Dependencies {


  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.1.1"
  lazy val akkaActor  = "com.typesafe.akka" %% "akka-actor" % "2.6.4"
  lazy val akkaHttp  = "com.typesafe.akka" %% "akka-http" % "10.1.11"
  lazy val akkaStream  = "com.typesafe.akka" %% "akka-stream" % "2.6.4"
  lazy val typesafeConf = "com.typesafe" % "config" % "1.4.0"
}

