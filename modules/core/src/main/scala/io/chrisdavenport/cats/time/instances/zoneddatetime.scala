package io.chrisdavenport.cats.time.instances

import cats._
import cats.implicits._
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.ISO_ZONED_DATE_TIME

trait zoneddatetime {

  final def showZonedDateTime(formatter: DateTimeFormatter): Show[ZonedDateTime] =
    Show[String].contramap(_.format(formatter))

  implicit final val zoneddatetimeInstances: Hash[ZonedDateTime]
    with Order[ZonedDateTime]
    with Show[ZonedDateTime] =
    new Hash[ZonedDateTime] with Order[ZonedDateTime] with Show[ZonedDateTime] {
      override def hash(x: ZonedDateTime): Int = x.hashCode
      override def compare(x: ZonedDateTime, y: ZonedDateTime): Int = x.compareTo(y)
      override def show(x: ZonedDateTime): String = x.format(ISO_ZONED_DATE_TIME)
    }
}

object zoneddatetime extends zoneddatetime

