package io.chrisdavenport.cats.time.instances

import cats._
import cats.implicits._

import java.time.{
  LocalTime,
  OffsetDateTime,
  OffsetTime,
  Period,
  YearMonth,
  ZoneId,
  ZonedDateTime
}
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.{
  ISO_LOCAL_TIME,
  ISO_OFFSET_DATE_TIME,
  ISO_OFFSET_TIME,
  ISO_ZONED_DATE_TIME
}

trait show {
  implicit final val zoneIdShow : Show[ZoneId] = Show[String].contramap(_.getId)


  final def showZonedDateTime(formatter: DateTimeFormatter): Show[ZonedDateTime] =
    Show[String].contramap(_.format(formatter))

  implicit final val showZonedDateTimeDefault = showZonedDateTime(ISO_ZONED_DATE_TIME)

  //

  final def showOffsetDateTime(formatter: DateTimeFormatter): Show[OffsetDateTime] =
    Show[String].contramap(_.format(formatter))

  implicit final val showOffsetDateTimeDefault = showOffsetDateTime(ISO_OFFSET_DATE_TIME)


  final def showLocalTime(formatter: DateTimeFormatter): Show[LocalTime] =
    Show[String].contramap(_.format(formatter))

  implicit final val showLocalTimeDefault = showLocalTime(ISO_LOCAL_TIME)

  //

  final def showOffsetTime(formatter: DateTimeFormatter): Show[OffsetTime] =
    Show[String].contramap(_.format(formatter))

  implicit final val showOffsetTimeDefault = showOffsetTime(ISO_OFFSET_TIME)

  //

  final def showYearMonth(formatter: DateTimeFormatter): Show[YearMonth] =
    Show[String].contramap(_.format(formatter))

  private final val yearMonthFormatter = DateTimeFormatter.ofPattern("yyyy-MM")

  implicit final val yearMonthPutDefault = showYearMonth(yearMonthFormatter)

  //

  implicit final val showPeriod : Show[Period] = Show.fromToString[Period]


}

object show extends show