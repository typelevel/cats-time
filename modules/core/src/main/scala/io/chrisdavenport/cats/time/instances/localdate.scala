package io.chrisdavenport.cats.time.instances

import cats._
import cats.syntax.all._
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.ISO_LOCAL_DATE

trait localdate {
  final def showLocalDate(formatter: DateTimeFormatter): Show[LocalDate] =
    Show[String].contramap(_.format(formatter))

  implicit final val localdateInstances = 
    new Show[LocalDate] with Order[LocalDate] with Hash[LocalDate]{
      override def hash(x: LocalDate): Int = x.hashCode
      override def compare(x: LocalDate, y: LocalDate): Int = x.compareTo(y)
      override def show(x: LocalDate): String = x.format(ISO_LOCAL_DATE)
    }
}

object localdate extends localdate