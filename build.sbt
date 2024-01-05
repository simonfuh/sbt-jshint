lazy val `sbt-jshint` = project in file(".")
enablePlugins(SbtWebBase)

description := "Allows JSHint to be used from within sbt"

//scalaVersion := "3.3.1"
//ThisBuild/scalaVersion := "3.3.1"

libraryDependencies ++= Seq(
  "org.webjars.npm" % "jshint" % "2.13.6",
//  "org.webjars.npm" % "jshint" % "2.13.4",
//  "org.webjars" % "strip-json-comments" % "1.0.2-1"
  "org.webjars.npm" % "strip-json-comments" % "3.1.1"
//  "org.webjars.npm" % "strip-json-comments" % "5.0.0"
)

//addSbtJsEngine("1.2.3")
addSbtJsEngine("1.3.5")
