Global / onChangedBuildSource := ReloadOnSourceChanges

val Scala213 = "2.13.16"
val Scala3 = "3.3.6"

ThisBuild / tlBaseVersion := "0.6"
ThisBuild / startYear := Some(2018)
ThisBuild / crossScalaVersions := Seq(Scala3, Scala213)

lazy val root = tlCrossRootProject.aggregate(core, tests, testKit)

lazy val core = crossProject(JSPlatform, JVMPlatform, NativePlatform)
  .crossType(CrossType.Pure)
  .in(file("modules/core"))
  .settings(commonSettings)
  .settings(
    name := "cats-time"
  )
  .platformsSettings(JSPlatform, NativePlatform)(
    libraryDependencies += "io.github.cquiroz" %%% "scala-java-time" % "2.6.0"
  )
  .nativeSettings(commonNativeSettings)

lazy val tests = crossProject(JSPlatform, JVMPlatform, NativePlatform)
  .crossType(CrossType.Pure)
  .in(file("modules/tests"))
  .dependsOn(core, testKit)
  .settings(commonSettings)
  .settings(
    name := "cats-time-tests"
  )
  .enablePlugins(NoPublishPlugin)

lazy val testKit = crossProject(JSPlatform, JVMPlatform, NativePlatform)
  .crossType(CrossType.Pure)
  .in(file("modules/testkit"))
  .settings(commonSettings)
  .settings(
    name := "cats-time-testkit",
    libraryDependencies ++= Seq(
      "org.scalacheck" %%% "scalacheck" % "1.19.0"
    )
  )
  .nativeSettings(commonNativeSettings)

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
    "org.typelevel" %%% "cats-core"        % "2.13.0",
    "org.typelevel" %%% "cats-laws"        % "2.13.0" % Test,
    "org.scalameta" %%% "munit"            % "1.2.1"  % Test,
    "org.typelevel" %%% "discipline-munit" % "2.0.0"  % Test
  )
)

lazy val commonNativeSettings = Seq(
  tlVersionIntroduced := List("2.12", "2.13", "3").map(_ -> "0.5.1").toMap
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
