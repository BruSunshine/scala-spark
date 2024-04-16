val scala3Version = "3.3.1"
scalaVersion := scala3Version

name := "scalaParallelProgramming"
version := "0.1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  //"org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.4",
  "org.scalameta" %% "munit-scalacheck" % "0.7.29" % Test,
  ("org.apache.spark" %% "spark-core" % "3.5.0").cross(CrossVersion.for3Use2_13),
  ("org.apache.spark" %% "spark-sql" % "3.5.0").cross(CrossVersion.for3Use2_13),
  ("com.storm-enroute" %% "scalameter-core" % "0.21" % Test).cross(CrossVersion.for3Use2_13)//,
  //("org.openjdk.jmh" %% "jmh-core" % "1.37" % Test) No need since the plugin is dealing with this
)

scalacOptions ++= Seq(
  "-Wunused:imports", // show warnings during compilation
  "-Ylog:typer"
)

enablePlugins(JmhPlugin)
//Jmh / sourceDirectory := (Test / sourceDirectory).value

Compile / unmanagedSourceDirectories += baseDirectory.value / "worksheets"
