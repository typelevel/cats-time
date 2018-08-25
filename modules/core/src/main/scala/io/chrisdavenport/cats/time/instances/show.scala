package io.chrisdavenport.cats.time.instances

import cats._
import cats.implicits._

import java.time.{
  Period,
  ZoneId,
  ZonedDateTime
}
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.{
  ISO_ZONED_DATE_TIME
}

trait show {
  implicit final val zoneIdShow : Show[ZoneId] = Show[String].contramap(_.getId)


  final def showZonedDateTime(formatter: DateTimeFormatter): Show[ZonedDateTime] =
    Show[String].contramap(_.format(formatter))

  implicit final val showZonedDateTimeDefault = showZonedDateTime(ISO_ZONED_DATE_TIME)


  implicit final val showPeriod : Show[Period] = Show.fromToString[Period]


}

object show extends show