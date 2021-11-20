lazy val `sbt-jshint` = project in file(".")

description := "Allows JSHint to be used from within sbt"


libraryDependencies ++= Seq(
  "org.webjars.npm" % "jshint" % "2.13.1",
//  "org.webjars" % "jshint" % "2.13.1",
//  "org.webjars" % "strip-json-comments" % "1.0.2-1"
  "org.webjars.npm" % "strip-json-comments" % "3.1.1"
)

addSbtJsEngine("1.2.2")
