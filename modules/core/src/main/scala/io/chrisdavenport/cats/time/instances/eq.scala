package io.chrisdavenport.cats.time.instances

import cats._

import java.time.{
  Duration,
  Instant,
  LocalDate,
  LocalDateTime,
  LocalTime,
  OffsetDateTime,
  OffsetTime,
  YearMonth,
  ZonedDateTime
}

trait order {
  implicit final val eqInstant: Order[Instant] = Order.from(_.compareTo(_))

  implicit final val eqLocalDateTime: Order[LocalDateTime] = Order.from(_.compareTo(_))

  implicit final val eqZonedDateTime: Order[ZonedDateTime] = Order.from(_.compareTo(_))

  implicit final val eqOffsetDateTime: Order[OffsetDateTime] = Order.from(_.compareTo(_))

  implicit final val eqLocalDate: Order[LocalDate] = Order.from(_.compareTo(_))

  implicit final val eqLocalTime: Order[LocalTime] = Order.from(_.compareTo(_))

  implicit final val eqOffsetTime: Order[OffsetTime] = Order.from(_.compareTo(_))

  implicit final val eqYearMonth: Order[YearMonth] = Order.from(_.compareTo(_))

  implicit final val eqDuration : Order[Duration] = Order.from(_.compareTo(_))
}

object order extends order