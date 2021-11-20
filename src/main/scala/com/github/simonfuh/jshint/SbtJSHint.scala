package com.github.simonfuh.jshint

import com.typesafe.sbt.jse.SbtJsTask
import com.typesafe.sbt.web.SbtWeb
import sbt.Keys.{baseDirectory, includeFilter, moduleName}
import sbt.{AllRequirements, AutoPlugin, File, IO, file, inTask}

import scala.reflect.io.Path.jfile2path

/**
 * The sbt plugin plumbing around the JSHint library.
 */
object SbtJSHint extends AutoPlugin {

  override def requires = SbtJsTask

  override def trigger = AllRequirements

  val autoImport = Import

  import SbtJsTask.autoImport.JsTaskKeys._
  import SbtWeb.autoImport._
  import WebKeys._
  import autoImport.JshintKeys._

  override def buildSettings = inTask(jshint)(
    SbtJsTask.jsTaskSpecificUnscopedBuildSettings ++ Seq(
      moduleName := "jshint",
      shellFile := getClass.getClassLoader.getResource("jshint-shell.js")
    )
  )

  override def projectSettings = Seq(
    config := None,
    resolvedConfig := {
      config.value.orElse {
        val JsHintRc = ".jshintrc"
//        val projectRc = baseDirectory.value / JsHintRc
        val projectRc = baseDirectory.value / JsHintRc
        if (projectRc.jfile.exists()) {
          Some(projectRc.jfile)
        } else {
          val homeRc = file(System.getProperty("user.home")) / JsHintRc
          if (homeRc.jfile.exists()) {
            Some(homeRc.jfile)
          } else {
            None
          }
        }
      }: Option[File]
    }
  ) ++ inTask(jshint)(
    SbtJsTask.jsTaskSpecificUnscopedProjectSettings ++ Seq(
      includeFilter in Assets := (jsFilter in Assets).value,
      includeFilter in TestAssets := (jsFilter in TestAssets).value,

      jsOptions := resolvedConfig.value.fold("{}")(IO.read(_)),

      taskMessage in Assets := "JavaScript linting",
      taskMessage in TestAssets := "JavaScript test linting"

    )
  ) ++ SbtJsTask.addJsSourceFileTasks(jshint)

}
