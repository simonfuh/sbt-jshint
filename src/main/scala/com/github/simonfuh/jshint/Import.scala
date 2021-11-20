package com.github.simonfuh.jshint

import sbt.{File, SettingKey, TaskKey}

object Import {

  object JshintKeys {

    val jshint = TaskKey[Seq[File]]("jshint", "Perform JavaScript linting.")

    val config = SettingKey[Option[File]]("jshint-config", "The location of a JSHint configuration file.")
    val resolvedConfig = TaskKey[Option[File]]("jshint-resolved-config", "The actual location of a JSHint configuration file if present. If jshint-config is none then the task will seek a .jshintrc in the project folder. If that's not found then .jshintrc will be searched for in the user's home folder. This behaviour is consistent with other JSHint tooling.")

  }

}
