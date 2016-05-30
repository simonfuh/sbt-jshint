sbtPlugin := true

organization := "com.typesafe.sbt"

name := "sbt-jshint"

version := "1.0.4-SNAPSHOT"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
  "org.webjars" % "jshint-node" % "2.4.3",
  "org.webjars" % "strip-json-comments" % "1.0.2-1"
)

addSbtPlugin("com.typesafe.sbt" % "sbt-js-engine" % "1.1.1")

publishMavenStyle := false

publishTo := {
  if (isSnapshot.value) Some(Classpaths.sbtPluginSnapshots)
  else Some(Classpaths.sbtPluginReleases)
}

scriptedSettings

scriptedLaunchOpts <+= version apply { v => s"-Dproject.version=$v" }
