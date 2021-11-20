publishMavenStyle := true
publishTo := Some("jshint" at "https://artifactory.simonfuh.github.com/artifactory/")
Test / publishArtifact := false
pomIncludeRepository := { _ => false }