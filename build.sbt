name := "LoggingTutorial"

version := "0.1"

scalaVersion := "2.11.8"

// https://mvnrepository.com/artifact/ch.qos.logback/logback-core
libraryDependencies += "ch.qos.logback" % "logback-core" % "1.2.3"

// https://mvnrepository.com/artifact/ch.qos.logback/logback-classic
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"

libraryDependencies += "net.logstash.logback" % "logstash-logback-encoder" % "5.2"

// https://mvnrepository.com/artifact/org.slf4j/slf4j-api
/*
libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.26"
libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.26"
*/

// https://mvnrepository.com/artifact/com.fasterxml.jackson.module/jackson-module-scala
libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.9.9"

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.3.0"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.3.0"
