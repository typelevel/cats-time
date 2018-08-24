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
  implicit final val orderInstant: Order[Instant] = Order.from(_.compareTo(_))

  implicit final val orderLocalDateTime: Order[LocalDateTime] = Order.from(_.compareTo(_))

  implicit final val orderZonedDateTime: Order[ZonedDateTime] = Order.from(_.compareTo(_))

  implicit final val orderOffsetDateTime: Order[OffsetDateTime] = Order.from(_.compareTo(_))

  implicit final val orderLocalDate: Order[LocalDate] = Order.from(_.compareTo(_))

  implicit final val orderLocalTime: Order[LocalTime] = Order.from(_.compareTo(_))

  implicit final val orderOffsetTime: Order[OffsetTime] = Order.from(_.compareTo(_))

  implicit final val orderYearMonth: Order[YearMonth] = Order.from(_.compareTo(_))

  implicit final val orderDuration : Order[Duration] = Order.from(_.compareTo(_))
}

object order extends order