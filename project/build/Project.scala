import sbt._

trait Defaults {
  this: DefaultProject =>
  
  val bryanjswift = "Bryan J Swift Repository" at "http://repos.bryanjswift.com/maven2/";
  val junitInterface = "com.novocode" % "junit-interface" % "0.4.0"
  
  lazy val junit = "junit" % "junit" % "4.6"  
}

class Project(info: ProjectInfo) extends DefaultProject(info) {

  lazy val common = project("common", "common", new DefaultProject(_) with Defaults)
  
  def projectBasedOnCommon(nameAndFolder: String) = project(nameAndFolder, nameAndFolder, new DefaultProject(_) with Defaults, common)
  
  lazy val firstClassFunctions = projectBasedOnCommon("first-class-functions")
  lazy val intro = projectBasedOnCommon("intro")
  lazy val ooTraits = projectBasedOnCommon("oo-traits")
  lazy val patternMatching = projectBasedOnCommon("pattern-matching")
}