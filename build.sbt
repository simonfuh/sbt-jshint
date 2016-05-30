lazy val `sbt-jshint` = project in file(".")

description := "Allows JSHint to be used from within sbt"

libraryDependencies ++= Seq(
  "org.webjars" % "jshint-node" % "2.6.3-2",
  "org.webjars" % "strip-json-comments" % "1.0.2-1"
)

addSbtJsEngine("1.1.3")
