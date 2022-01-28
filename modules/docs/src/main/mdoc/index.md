# cats-time

[![Build Status](https://github.com/ChristopherDavenport/cats-time/workflows/CI/badge.svg)](https://github.com/ChristopherDavenport/cats-time/actions?query=workflow%3ACI+branch%3Amaster) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.typelevel/cats-time_2.13/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.typelevel/cats-time_2.13)

Instances for Cats Typeclasses for Java 8 Time. Similar to the encoding that are offered in Circe and Cormorant.

Time is a pain to deal with reasonably. So tread with caution.

## Quick Start

To use cats-time in an existing SBT project with Scala 2.11 or a later version, add the following dependencies to your
`build.sbt` depending on your needs:

```scala
libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-time"     % "@VERSION@"
)
```

## Examples

First lets start with some imports.

```scala mdoc:silent
import org.typelevel.cats.time._
import cats.implicits._
import java.time._
```

Then we can display the `Show` instances.

```scala mdoc
Duration.ofDays(3).show

Instant.now.show

LocalDate.now.show

LocalDateTime.now.show

LocalTime.now.show

MonthDay.now.show

OffsetDateTime.now.show

OffsetTime.now.show

Period.ofWeeks(6).show

Year.now.show

YearMonth.now.show

ZoneId.systemDefault.show

ZonedDateTime.now.show
```