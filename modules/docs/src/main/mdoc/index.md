---
layout: home

---
# cats-time [![Build Status](https://travis-ci.com/ChristopherDavenport/cats-time.svg?branch=master)](https://travis-ci.com/ChristopherDavenport/cats-time) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.chrisdavenport/cats-time_2.13/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.chrisdavenport/cats-time_2.13)

Instances for Cats Typeclasses for Java 8 Time. Similar to the encoding that are offered in Circe and Cormorant.

Time is a pain to deal with reasonably. So tread with caution.

## Quick Start

To use cats-time in an existing SBT project with Scala 2.11 or a later version, add the following dependencies to your
`build.sbt` depending on your needs:

```scala
libraryDependencies ++= Seq(
  "io.chrisdavenport" %% "cats-time"     % "<version>"
)
```

## Examples

First lets start with some imports.

```scala mdoc:silent
import io.chrisdavenport.cats.time._
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