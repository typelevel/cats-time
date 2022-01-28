/*
 * Copyright (c) 2018 Typelevel
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package org.typelevel.cats.time.arb

import java.time._

import org.scalacheck.{Arbitrary, Cogen, Gen}
import org.scalacheck.Arbitrary.arbitrary

trait TimeArbitraries {

  implicit val arbitraryZoneId: Arbitrary[ZoneId] = Arbitrary {
    import scala.jdk.CollectionConverters._
    Gen.oneOf(ZoneId.getAvailableZoneIds.asScala.map(ZoneId.of).toSeq)
  }

  implicit lazy val cogenZoneId: Cogen[ZoneId] =
    Cogen[String].contramap(_.getId)

  implicit val arbitraryZoneOffset: Arbitrary[ZoneOffset] = Arbitrary {
    // Range is specified in `ofTotalSeconds` javadoc.
    Gen.choose(-64800, 64800).map(ZoneOffset.ofTotalSeconds)
  }

  implicit lazy val cogenZoneOffset: Cogen[ZoneOffset] =
    Cogen[Int].contramap(_.getTotalSeconds)

  implicit val arbitraryInstant: Arbitrary[Instant] = Arbitrary(
    Gen.choose(Instant.MIN.getEpochSecond, Instant.MAX.getEpochSecond).map(Instant.ofEpochSecond)
  )

  implicit lazy val cogenInstant: Cogen[Instant] =
    Cogen[(Long, Int)].contramap(t => (t.getEpochSecond, t.getNano))

  implicit val arbitraryPeriod: Arbitrary[Period] = Arbitrary(
    for {
      years <- arbitrary[Int]
      months <- arbitrary[Int]
      days <- arbitrary[Int]
    } yield Period.of(years, months, days)
  )

  implicit lazy val cogenPeriod: Cogen[Period] =
    Cogen[(Int, Int, Int)].contramap(t => (t.getDays, t.getMonths, t.getYears))

  implicit val arbitraryLocalDateTime: Arbitrary[LocalDateTime] = Arbitrary(
    for {
      instant <- arbitrary[Instant]
      zoneId <- arbitrary[ZoneId]
    } yield LocalDateTime.ofInstant(instant, zoneId)
  )

  implicit lazy val cogenLocalDateTime: Cogen[LocalDateTime] =
    Cogen[(LocalDate, LocalTime)].contramap(t => (t.toLocalDate, t.toLocalTime))

  implicit val arbitraryZonedDateTime: Arbitrary[ZonedDateTime] = Arbitrary(
    for {
      instant <- arbitrary[Instant]
      zoneId <- arbitrary[ZoneId]
    } yield ZonedDateTime.ofInstant(instant, zoneId)
  )

  implicit lazy val cogenZonedDateTime: Cogen[ZonedDateTime] =
    Cogen[(LocalDateTime, ZoneId)].contramap(d => (d.toLocalDateTime, d.getZone))

  implicit val arbitraryOffsetDateTime: Arbitrary[OffsetDateTime] = Arbitrary(
    for {
      instant <- arbitrary[Instant]
      zoneId <- arbitrary[ZoneId]
    } yield OffsetDateTime.ofInstant(instant, zoneId)
  )

  implicit lazy val cogenOffsetDateTime: Cogen[OffsetDateTime] =
    Cogen[(LocalDateTime, ZoneOffset)].contramap(d => (d.toLocalDateTime, d.getOffset))

  implicit val arbitraryLocalDate: Arbitrary[LocalDate] = Arbitrary(
    arbitrary[LocalDateTime].map(_.toLocalDate)
  )

  implicit lazy val cogenLocalDate: Cogen[LocalDate] =
    Cogen[(Int, Int)].contramap(d => (d.getYear, d.getDayOfYear))

  implicit val arbitraryLocalTime: Arbitrary[LocalTime] = Arbitrary(
    arbitrary[LocalDateTime].map(_.toLocalTime)
  )

  implicit lazy val cogenLocalTime: Cogen[LocalTime] =
    Cogen[Long].contramap(_.toNanoOfDay)

  implicit val arbitraryOffsetTime: Arbitrary[OffsetTime] = Arbitrary(
    arbitrary[OffsetDateTime].map(_.toOffsetTime)
  )

  implicit lazy val cogenOffsetTime: Cogen[OffsetTime] =
    Cogen[(LocalTime, ZoneOffset)].contramap(d => (d.toLocalTime, d.getOffset))

  implicit val arbitraryYearMonth: Arbitrary[YearMonth] = Arbitrary(
    arbitrary[LocalDateTime].map(ldt => YearMonth.of(ldt.getYear, ldt.getMonth))
  )

  implicit lazy val cogenYearMonth: Cogen[YearMonth] =
    Cogen[(Int, Int)].contramap(d => (d.getMonthValue, d.getYear))

  implicit val arbitraryYear: Arbitrary[Year] = Arbitrary(
    arbitrary[LocalDateTime].map(ldt => Year.of(ldt.getYear))
  )

  implicit lazy val cogenYear: Cogen[Year] =
    Cogen[Int].contramap(_.getValue)

  implicit val arbitraryDuration: Arbitrary[Duration] = Arbitrary(
    for {
      first <- arbitrary[Instant]
      second <- arbitrary[Instant]
    } yield Duration.between(first, second)
  )

  implicit lazy val cogenDuration: Cogen[Duration] =
    Cogen[(Long, Int)].contramap(d => (d.getSeconds, d.getNano))

  implicit val arbitraryMonthDay: Arbitrary[MonthDay] = Arbitrary(
    arbitrary[LocalDateTime].map(ldt => MonthDay.of(ldt.getMonth, ldt.getDayOfMonth))
  )

  implicit lazy val cogenMonthDay: Cogen[MonthDay] =
    Cogen[(Int, Int)].contramap(d => (d.getMonthValue, d.getDayOfMonth))

  implicit val arbitraryMonth: Arbitrary[Month] = Arbitrary(arbitrary[MonthDay].map(_.getMonth))

  implicit lazy val cogenMonth: Cogen[Month] =
    Cogen[Int].contramap(_.getValue)

}

object TimeArbitraries extends TimeArbitraries
