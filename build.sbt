lazy val root = (project in file(".")).enablePlugins(PlayScala)

name := "sbt-target-example"

version := "1.0"

scalaVersion := "2.10.4"


val env = sys.props.getOrElse("ENV", default = "local") 

val envData = env match {
	case "local" => EnvData("1.7","1.7","1.7")
	case "stage" => EnvData("1.6","1.6","1.6")
	case "production" => EnvData("1.7","1.7","1.8")
}


val targetJvm = s"-target:jvm-${envData.jvm}" 

scalacOptions := Seq(
  "-unchecked",
  "-deprecation",
  "-feature",
  "-encoding", "utf8",
  targetJvm
)

javacOptions ++= Seq("-source", envData.source, "-target", envData.target)
