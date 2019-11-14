import com.typesafe.sbt.packager.docker.Cmd

enablePlugins(JavaAppPackaging, DockerPlugin)

dockerBaseImage := "lustefaniak/docker-gcp-java:alpine-graalvm8_1.7"
defaultLinuxInstallLocation in Docker := s"/opt/\${(packageName in Docker).value}"
dockerEntrypoint := Seq("/docker-entrypoint.bash")
dockerExposedPorts := Seq(8080)
dockerExposedUdpPorts := Seq.empty[Int]
dockerCmd := Seq(s"/opt/\${(packageName in Docker).value}/bin/\${(name in Docker).value}")
publishArtifact in packageDoc := false

dockerCommands ++= Seq(
  Cmd("ENV", "GCP_APP_NAME", name.value),
  Cmd("ENV", "GCP_APP_VERSION", version.value)
)