package io.chrisdavenport.cats.time.instances

import java.time.MonthDay
import java.time.format.DateTimeFormatter

import cats._

trait monthday {
  implicit final val monthdayInstances =
    new Show[MonthDay] with Order[MonthDay] with Hash[MonthDay] with Eq[MonthDay] {
      override def compare(x: MonthDay, y: MonthDay): Int = x.compareTo(y)
      override def hash(x: MonthDay): Int = x.hashCode
      override def show(x: MonthDay): String = x.format(DateTimeFormatter.ofPattern("M-d"))
      override def eqv(x: MonthDay, y: MonthDay): Boolean = x.equals(y)
    }
}

object monthday extends monthday
