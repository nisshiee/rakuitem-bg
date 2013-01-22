import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "rakuitem-bg"
    val appVersion      = "1.0.0"

    val appDependencies = Seq(
      // Add your project dependencies here,
       "org.nisshiee" % "rws-scala_2.9.2" % "0.1.0"
      ,"org.nisshiee" % "rws-scala-dispatch_2.9.2" % "0.1.0"
      ,"org.twitter4j" % "twitter4j-core" % "3.0.3"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      // Add your own project settings here      
    )

}
