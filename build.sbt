name := "redis-test"

version := "1.0"

scalaVersion := "2.13.1"
enablePlugins(DockerPlugin)
dockerBaseImage := "openjdk"

enablePlugins(JavaAppPackaging)


mainClass in (Compile, run) := Some("com.tomtom.navcloud.redistest.RedisTest")

lazy val akkaVersion = "2.6.17"

resolvers += Resolver.bintrayRepo("scredis","maven")

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "ch.qos.logback" % "logback-classic" % "1.2.3",
)

libraryDependencies += "com.github.scredis" %% "scredis" % "2.4.3"

