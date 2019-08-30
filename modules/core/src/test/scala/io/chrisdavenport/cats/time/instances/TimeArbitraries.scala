package io.chrisdavenport.cats.time.instances

import java.time._

import org.scalacheck.{ Arbitrary, Gen }
import org.scalacheck.Arbitrary.arbitrary


object TimeArbitraries {

  implicit def functionArbitrary[B, A: Arbitrary]: Arbitrary[B => A] = Arbitrary{
    for {
      a <- Arbitrary.arbitrary[A]
    } yield {_: B => a}
  }

  implicit val arbitraryZoneId: Arbitrary[ZoneId] = Arbitrary{
    import scala.jdk.CollectionConverters._
    Gen.oneOf(ZoneId.getAvailableZoneIds.asScala.map(ZoneId.of).toSeq)
  }

  implicit val arbitraryZoneOffset: Arbitrary[ZoneOffset] = Arbitrary{
    // Range is specified in `ofTotalSeconds` javadoc.
    Gen.choose(-64800, 64800).map(ZoneOffset.ofTotalSeconds)
  }

  implicit val arbitraryInstant: Arbitrary[Instant] = Arbitrary(
    Gen.choose(Instant.MIN.getEpochSecond, Instant.MAX.getEpochSecond).map(Instant.ofEpochSecond)
  )

  implicit val arbitraryPeriod: Arbitrary[Period] = Arbitrary(
    for {
      years <- arbitrary[Int]
      months <- arbitrary[Int]
      days <- arbitrary[Int]
    } yield Period.of(years, months, days)
  )

  implicit val arbitraryLocalDateTime: Arbitrary[LocalDateTime] = Arbitrary(
    for {
      instant <- arbitrary[Instant]
      zoneId  <- arbitrary[ZoneId]
    } yield LocalDateTime.ofInstant(instant, zoneId)
  )

  implicit val arbitraryZonedDateTime: Arbitrary[ZonedDateTime] = Arbitrary(
    for {
      instant <- arbitrary[Instant]
      zoneId  <- arbitrary[ZoneId]
    } yield ZonedDateTime.ofInstant(instant, zoneId)
  )

  implicit val arbitraryOffsetDateTime: Arbitrary[OffsetDateTime] = Arbitrary(
    for {
      instant <- arbitrary[Instant]
      zoneId  <- arbitrary[ZoneId]
    } yield OffsetDateTime.ofInstant(instant, zoneId)
  )

  implicit val arbitraryLocalDate: Arbitrary[LocalDate] = Arbitrary(arbitrary[LocalDateTime].map(_.toLocalDate))

  implicit val arbitraryLocalTime: Arbitrary[LocalTime] = Arbitrary(arbitrary[LocalDateTime].map(_.toLocalTime))

  implicit val arbitraryOffsetTime: Arbitrary[OffsetTime] = Arbitrary(arbitrary[OffsetDateTime].map(_.toOffsetTime))

  implicit val arbitraryYearMonth: Arbitrary[YearMonth] = Arbitrary(arbitrary[LocalDateTime].map(
    ldt => YearMonth.of(ldt.getYear, ldt.getMonth)))

  implicit val arbitraryYear: Arbitrary[Year] = Arbitrary(arbitrary[LocalDateTime].map(
    ldt => Year.of(ldt.getYear)))

  implicit val arbitraryDuration: Arbitrary[Duration] = Arbitrary(
    for {
      first <- arbitrary[Instant]
      second <- arbitrary[Instant]
    } yield Duration.between(first, second)
  )

  implicit val arbitraryMonthDay: Arbitrary[MonthDay] = Arbitrary(arbitrary[LocalDateTime].map(
    ldt => MonthDay.of(ldt.getMonth, ldt.getDayOfMonth)))
}