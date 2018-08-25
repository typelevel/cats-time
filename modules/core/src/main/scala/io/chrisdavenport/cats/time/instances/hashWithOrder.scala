package io.chrisdavenport.cats.time.instances

import cats._

import java.time.{
  YearMonth,
  ZonedDateTime
}

trait hashWithOrder {

  implicit final val hashWithOrderZonedDateTime: Hash[ZonedDateTime] with Order[ZonedDateTime] =
    new Hash[ZonedDateTime] with Order[ZonedDateTime] {
      override def hash(x: ZonedDateTime): Int = x.hashCode
      override def compare(x: ZonedDateTime, y: ZonedDateTime): Int = x.compareTo(y)
    }

  implicit final val hashWithOrderYearMonth: Hash[YearMonth] with Order[YearMonth] =
    new Hash[YearMonth] with Order[YearMonth] {
      override def hash(x: YearMonth): Int = x.hashCode
      override def compare(x: YearMonth, y: YearMonth): Int = x.compareTo(y)
    }
}

object hashWithOrder extends hashWithOrder