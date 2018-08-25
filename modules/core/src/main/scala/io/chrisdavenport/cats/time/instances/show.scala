package io.chrisdavenport.cats.time.instances

import cats._
import cats.implicits._

import java.time.{
  Period,
  YearMonth,
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

  final def showYearMonth(formatter: DateTimeFormatter): Show[YearMonth] =
    Show[String].contramap(_.format(formatter))

  private final val yearMonthFormatter = DateTimeFormatter.ofPattern("yyyy-MM")

  implicit final val yearMonthPutDefault = showYearMonth(yearMonthFormatter)

  //

  implicit final val showPeriod : Show[Period] = Show.fromToString[Period]


}

object show extends show