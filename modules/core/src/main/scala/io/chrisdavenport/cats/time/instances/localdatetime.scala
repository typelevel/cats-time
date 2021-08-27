package io.chrisdavenport.cats.time.instances

import cats._
import cats.implicits._
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME

trait localdatetime {
  final def showLocalDateTime(formatter: DateTimeFormatter): Show[LocalDateTime] =
    Show[String].contramap(_.format(formatter))

  implicit final val localdatetimeInstances: Show[LocalDateTime] with Order[LocalDateTime] with Hash[LocalDateTime] =
    new Show[LocalDateTime] with Order[LocalDateTime] with Hash[LocalDateTime]{
      override def hash(x: LocalDateTime): Int = x.hashCode
      override def compare(x: LocalDateTime, y: LocalDateTime): Int = x.compareTo(y)
      override def show(x: LocalDateTime): String = x.format(ISO_LOCAL_DATE_TIME)
    }
}

object localdatetime extends localdatetime
