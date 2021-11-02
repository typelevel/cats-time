package io.chrisdavenport.cats.time.instances

import cats._
import cats.implicits._
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME

trait offsetdatetime {
  final def showOffsetDateTime(formatter: DateTimeFormatter): Show[OffsetDateTime] =
    Show[String].contramap(_.format(formatter))

  implicit final val offsetdatetimeInstances: Show[OffsetDateTime]
    with Order[OffsetDateTime]
    with Hash[OffsetDateTime] =
    new Show[OffsetDateTime] with Order[OffsetDateTime] with Hash[OffsetDateTime] {
      override def hash(x: OffsetDateTime): Int = x.hashCode
      override def compare(x: OffsetDateTime, y: OffsetDateTime): Int = x.compareTo(y)
      override def show(x: OffsetDateTime): String = x.format(ISO_OFFSET_DATE_TIME)
    }
}

object offsetdatetime extends offsetdatetime
