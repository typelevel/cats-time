Global / onChangedBuildSource := ReloadOnSourceChanges

val Scala212 = "2.12.16"
val Scala213 = "2.13.8"
val Scala3 = "3.1.2"

ThisBuild / tlBaseVersion := "0.5"
ThisBuild / startYear := Some(2018)
ThisBuild / crossScalaVersions := Seq(Scala212, Scala3, Scala213)

lazy val root = tlCrossRootProject.aggregate(core, tests, testKit)

lazy val core = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Pure)
  .in(file("modules/core"))
  .settings(commonSettings)
  .settings(
    name := "cats-time"
  )
  .jsSettings(
    libraryDependencies += "io.github.cquiroz" %%% "scala-java-time" % "2.4.0"
  )

lazy val tests = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Pure)
  .in(file("modules/tests"))
  .dependsOn(core, testKit)
  .settings(commonSettings)
  .settings(
    name := "cats-time-tests"
  )
  .enablePlugins(NoPublishPlugin)

lazy val testKit = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Pure)
  .in(file("modules/testkit"))
  .settings(commonSettings)
  .settings(
    name := "cats-time-testkit",
    libraryDependencies ++= Seq(
      "org.scalacheck" %%% "scalacheck"                      % "1.16.0",
      "org.scala-lang.modules" %%% "scala-collection-compat" % "2.7.0"
    )
  )

lazy val docs = project
  .in(file("modules/docs"))
  .settings(commonSettings)
  .dependsOn(core.jvm)
  .enablePlugins(TypelevelSitePlugin)
  .enablePlugins(NoPublishPlugin)
  .settings(mdocIn := sourceDirectory.value / "main" / "mdoc")

// General Settings
lazy val commonSettings = Seq(
  organization := "org.typelevel",
  libraryDependencies ++= Seq(
    "org.typelevel" %%% "cats-core"                        % "2.7.0",
    "org.typelevel" %%% "cats-laws"                        % "2.7.0"  % Test,
    "org.scalameta" %%% "munit"                            % "0.7.29" % Test,
    "org.typelevel" %%% "discipline-munit"                 % "1.0.9"  % Test,
    "org.scala-lang.modules" %%% "scala-collection-compat" % "2.7.0"  % Test
  )
)

// General Settings
inThisBuild(
  List(
    developers := List(
      Developer(
        "ChristopherDavenport",
        "Christopher Davenport",
        "chris@christopherdavenport.tech",
        url("https://github.com/ChristopherDavenport")
      )
    ),
    licenses := List("MIT" -> url("https://opensource.org/licenses/MIT"))
  )
)
