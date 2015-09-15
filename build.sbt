organization := "name.tanglei"

name := "sbtJavaDemo"

version := "1.0-SNAPSHOT"

// This forbids including Scala related libraries into the dependency
autoScalaLibrary := false

// Do not append Scala versions to the generated artifacts
crossPaths := false

resolvers += "local maven" at ("file://%s/.m2/repository" format Path.userHome.absolutePath)

mainClass in (Compile, run) := Some("name.tanglei.Test")

// library dependencies. (orginization name) % (project name) % (version)
libraryDependencies ++= Seq( 
   "org.apache.poi" % "poi" % "3.12",
   "org.apache.poi" % "poi-ooxml" % "3.12"
)

libraryDependencies += "net.sourceforge.jexcelapi" % "jxl" % "2.6.12"
