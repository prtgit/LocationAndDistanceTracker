name := "play2java"
 
version := "1.0" 
      
lazy val `play2java` = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
scalaVersion := "2.11.11"

libraryDependencies ++= Seq( javaJdbc , cache , javaWs, evolutions,  "org.xerial" % "sqlite-jdbc" % "3.8.6" )



libraryDependencies ++= Seq( ws )

fork in run := false
resolvers += "SQLite-JDBC Repository" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies += guice


      