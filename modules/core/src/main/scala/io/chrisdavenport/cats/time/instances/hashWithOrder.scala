package io.chrisdavenport.cats.time.instances

import cats._

import java.time.{
  Instant,
  LocalDate,
  LocalDateTime,
  LocalTime,
  OffsetDateTime,
  OffsetTime,
  YearMonth,
  ZonedDateTime
}

trait hashWithOrder {
  implicit final val hashWithOrderInstant: Hash[Instant] with Order[Instant] =
    new Hash[Instant] with Order[Instant] {
      override def hash(x: Instant): Int = x.hashCode
      override def compare(x: Instant, y: Instant): Int = x.compareTo(y)
    }

  implicit final val hashWithOrderLocalDateTime: Hash[LocalDateTime] with Order[LocalDateTime] =
    new Hash[LocalDateTime] with Order[LocalDateTime] {
      override def hash(x: LocalDateTime): Int = x.hashCode
      override def compare(x: LocalDateTime, y: LocalDateTime): Int = x.compareTo(y)
    }

  implicit final val hashWithOrderZonedDateTime: Hash[ZonedDateTime] with Order[ZonedDateTime] =
    new Hash[ZonedDateTime] with Order[ZonedDateTime] {
      override def hash(x: ZonedDateTime): Int = x.hashCode
      override def compare(x: ZonedDateTime, y: ZonedDateTime): Int = x.compareTo(y)
    }

  implicit final val hashWithOrderOffsetDateTime: Hash[OffsetDateTime] with Order[OffsetDateTime] =
    new Hash[OffsetDateTime] with Order[OffsetDateTime] {
      override def hash(x: OffsetDateTime): Int = x.hashCode
      override def compare(x: OffsetDateTime, y: OffsetDateTime): Int = x.compareTo(y)
    }

  implicit final val hashWithOrderLocalDate: Hash[LocalDate] with Order[LocalDate] =
    new Hash[LocalDate] with Order[LocalDate] {
      override def hash(x: LocalDate): Int = x.hashCode
      override def compare(x: LocalDate, y: LocalDate): Int = x.compareTo(y)
    }

  implicit final val hashWithOrderLocalTime: Hash[LocalTime] with Order[LocalTime] =
    new Hash[LocalTime] with Order[LocalTime] {
      override def hash(x: LocalTime): Int = x.hashCode
      override def compare(x: LocalTime, y: LocalTime): Int = x.compareTo(y)
  }

  implicit final val hashWithOrderOffsetTime: Hash[OffsetTime] with Order[OffsetTime] =
    new Hash[OffsetTime] with Order[OffsetTime] {
      override def hash(x: OffsetTime): Int = x.hashCode
      override def compare(x: OffsetTime, y: OffsetTime): Int = x.compareTo(y)
    }

  implicit final val hashWithOrderYearMonth: Hash[YearMonth] with Order[YearMonth] =
    new Hash[YearMonth] with Order[YearMonth] {
      override def hash(x: YearMonth): Int = x.hashCode
      override def compare(x: YearMonth, y: YearMonth): Int = x.compareTo(y)
    }
}

object hashWithOrder extends hashWithOrder