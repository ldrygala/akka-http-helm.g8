ThisBuild / organization := "$organization$"
ThisBuild / scalaVersion := "$scala_version$"
ThisBuild / version      := "0.1.0"

lazy val root = (project in file(".")).
  settings(
    name := "$name$",
    scalaVersion := "$scala_version$",
    libraryDependencies ++= {
      val AkkaHttpVersion = "$akka_http_version$"
      val AkkaVersion = "$akka_version$"

      val akka = Seq(
        "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion,
        "com.typesafe.akka" %% "akka-stream" % AkkaVersion
      )

      val testing = Seq(
        "org.scalatest" %% "scalatest" % "3.0.8" % Test,
        "com.typesafe.akka" %% "akka-http-testkit" % AkkaHttpVersion % Test,
        "com.typesafe.akka" %% "akka-testkit" % AkkaVersion % Test
      )
    
      akka ++ testing
    }
  )
