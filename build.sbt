lazy val `sbt-jshint` = project in file(".")

description := "Allows JSHint to be used from within sbt"


libraryDependencies ++= Seq(
  "org.webjars.npm" % "jshint" % "2.13.6",
//  "org.webjars.npm" % "jshint" % "2.13.4",
//  "org.webjars" % "strip-json-comments" % "1.0.2-1"
  "org.webjars.npm" % "strip-json-comments" % "3.1.1"
//  "org.webjars.npm" % "strip-json-comments" % "5.0.0"
)

//addSbtJsEngine("1.2.2")
addSbtJsEngine("1.2.3")
