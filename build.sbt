lazy val root = (project in file(".")).enablePlugins(PlayScala)

name := "sbt-target-example"

version := "1.0"

scalaVersion := "2.10.4"


val javaTargetVersion = sys.props.getOrElse("JAVATARGET", default = "1.7") 

val targetJvm = s"-target:jvm-$javaTargetVersion" 

scalacOptions := Seq(
  "-unchecked",
  "-deprecation",
  "-feature",
  "-encoding", "utf8",
  targetJvm
)

javacOptions ++= Seq("-source", javaTargetVersion, "-target", javaTargetVersion)
