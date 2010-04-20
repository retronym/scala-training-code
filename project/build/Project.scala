import sbt._


class Project(info: ProjectInfo) extends DefaultProject(info) {

  lazy val common = project("common", "common", new DefaultProject(_) {
    lazy val junit = "junit" % "junit" % "4.6"
  })
  
  def projectBasedOnCommon(nameAndFolder: String) = project(nameAndFolder, nameAndFolder, new DefaultProject(_) {
    lazy val junit = "junit" % "junit" % "4.6"
  }, common)
  
  lazy val firstClassFunctions = projectBasedOnCommon("first-class-functions")
  lazy val intro = projectBasedOnCommon("intro")
  lazy val ooTraits = projectBasedOnCommon("oo-traits")
  lazy val patternMatching = projectBasedOnCommon("pattern-matching")

}