import sbtcrossproject.CrossPlugin.autoImport.{crossProject, CrossType}

lazy val `cats-time` = project
  .in(file("."))
  .disablePlugins(MimaPlugin)
  .enablePlugins(NoPublishPlugin)
  .settings(commonSettings)
  .aggregate(coreJS, coreJVM)

lazy val core = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Pure)
  .in(file("modules/core"))
  .settings(commonSettings)
  .settings(
    name := "cats-time"
  )
  .jsSettings(
    libraryDependencies += "io.github.cquiroz" %%% "scala-java-time" % "2.2.2"
  )

lazy val coreJS = core.js
lazy val coreJVM = core.jvm

lazy val docs = project
  .in(file("modules/docs"))
  .settings(commonSettings, micrositeSettings)
  .dependsOn(coreJVM)
  .disablePlugins(MimaPlugin)
  .enablePlugins(MicrositesPlugin)
  .enablePlugins(MdocPlugin)
  .enablePlugins(NoPublishPlugin)
  .settings(mdocIn := sourceDirectory.value / "main" / "mdoc")

// General Settings
lazy val commonSettings = Seq(
  scalaVersion := "2.13.5",
  crossScalaVersions := Seq(scalaVersion.value, "2.12.13"),
  addCompilerPlugin("org.typelevel" % "kind-projector"     % "0.13.0" cross CrossVersion.full),
  addCompilerPlugin("com.olegpy"   %% "better-monadic-for" % "0.3.1"),
  libraryDependencies ++= Seq(
    "org.typelevel" %%% "cats-core"                        % "2.6.1",
    "org.scala-lang.modules" %%% "scala-collection-compat" % "2.4.4" % Test,
    "org.typelevel" %%% "cats-testkit-scalatest"           % "2.1.5" % Test
  )
)

lazy val micrositeSettings = Seq(
  micrositeName := "cats-time",
  micrositeDescription := "Cats Typeclasses for Java Time",
  micrositeAuthor := "Christopher Davenport",
  micrositeGithubOwner := "typelevel",
  micrositeGithubRepo := "cats-time",
  micrositeBaseUrl := "/cats-time",
  micrositeDocumentationUrl := "https://typelevel.org/cats-time",
  micrositeFooterText := None,
  micrositeHighlightTheme := "atom-one-light",
  micrositePalette := Map(
    "brand-primary" -> "#3e5b95",
    "brand-secondary" -> "#294066",
    "brand-tertiary" -> "#2d5799",
    "gray-dark" -> "#49494B",
    "gray" -> "#7B7B7E",
    "gray-light" -> "#E5E5E6",
    "gray-lighter" -> "#F4F3F4",
    "white-color" -> "#FFFFFF"
  ),
  scalacOptions in Compile --= Seq(
    "-Xfatal-warnings",
    "-Ywarn-unused-import",
    "-Ywarn-numeric-widen",
    "-Ywarn-dead-code",
    "-Ywarn-unused:imports",
    "-Xlint:-missing-interpolator,_"
  ),
  libraryDependencies += "com.47deg" %% "github4s" % "0.24.1",
  micrositePushSiteWith := GitHub4s,
  micrositeGitterChannel := true,
  micrositeGitterChannelUrl := "typelevel/cats",
  micrositeGithubToken := sys.env.get("GITHUB_TOKEN")
)

// General Settings
inThisBuild(
  List(
    organization := "io.chrisdavenport",
    developers := List(
      Developer(
        "ChristopherDavenport",
        "Christopher Davenport",
        "chris@christopherdavenport.tech",
        url("https://github.com/ChristopherDavenport")
      )
    ),
    homepage := Some(url("https://github.com/typelevel/cats-time")),
    licenses += ("MIT", url("http://opensource.org/licenses/MIT")),
    pomIncludeRepository := { _ => false },
    scalacOptions in (Compile, doc) ++= Seq(
      "-groups",
      "-sourcepath",
      (baseDirectory in LocalRootProject).value.getAbsolutePath,
      "-doc-source-url",
      "https://github.com/typelevel/cats-time/blob/v" + version.value + "€{FILE_PATH}.scala"
    )
  )
)
