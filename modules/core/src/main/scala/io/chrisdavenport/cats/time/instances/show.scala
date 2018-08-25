package io.chrisdavenport.cats.time.instances

import cats._
import cats.implicits._

import java.time.{
  Duration,
  LocalDate,
  LocalDateTime,
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
  ISO_LOCAL_DATE,
  ISO_LOCAL_DATE_TIME,
  ISO_LOCAL_TIME,
  ISO_OFFSET_DATE_TIME,
  ISO_OFFSET_TIME,
  ISO_ZONED_DATE_TIME
}

trait show {
  implicit final val zoneIdShow : Show[ZoneId] = Show[String].contramap(_.getId)

  final def showLocalDateTime(formatter: DateTimeFormatter): Show[LocalDateTime] =
    Show[String].contramap(_.format(formatter))

  implicit final val showLocalDateTimeDefault = showLocalDateTime(ISO_LOCAL_DATE_TIME)

  //

  final def showZonedDateTime(formatter: DateTimeFormatter): Show[ZonedDateTime] =
    Show[String].contramap(_.format(formatter))

  implicit final val showZonedDateTimeDefault = showZonedDateTime(ISO_ZONED_DATE_TIME)

  //

  final def showOffsetDateTime(formatter: DateTimeFormatter): Show[OffsetDateTime] =
    Show[String].contramap(_.format(formatter))

  implicit final val showOffsetDateTimeDefault = showOffsetDateTime(ISO_OFFSET_DATE_TIME)

  //

  final def showLocalDate(formatter: DateTimeFormatter): Show[LocalDate] =
    Show[String].contramap(_.format(formatter))

  implicit final val showLocalDateDefault = showLocalDate(ISO_LOCAL_DATE)

  //

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

  implicit final val showDuration : Show[Duration] = Show.fromToString[Duration]


}

object show extends show