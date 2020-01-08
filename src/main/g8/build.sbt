ThisBuild / organization := "$organization$"
ThisBuild / scalaVersion := "$scala_version$"
ThisBuild / version      := "0.1.0"

lazy val IntegrationTest = config("it") extend Test
lazy val root = (project in file("."))
  .configs(IntegrationTest)
  .settings(
    Defaults.itSettings,
    inConfig(IntegrationTest)(org.scalafmt.sbt.ScalafmtPlugin.scalafmtConfigSettings)
  )
  .settings(
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

      val logging = Seq(
        "com.typesafe.scala-logging" %% "scala-logging"           % "$scala_logging_version$",
        "ch.qos.logback"             % "logback-classic"          % "$logback_version$",
        "net.logstash.logback"       % "logstash-logback-encoder" % "$logstash_encoder_version$",
      )
    
      akka ++ logging ++ testing
    }
  )
