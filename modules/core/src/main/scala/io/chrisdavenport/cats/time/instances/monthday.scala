package io.chrisdavenport.cats.time.instances

import java.time.MonthDay
import java.time.format.DateTimeFormatter

import cats.{ Hash, Order, Show }

trait monthday {
  implicit final val monthdayInstances =
    new Show[MonthDay] with Order[MonthDay] with Hash[MonthDay] {
      def compare(x: MonthDay, y: MonthDay): Int = x.compareTo(y)

      def hash(x: MonthDay): Int = x.hashCode

      def show(x: MonthDay): String = x.format(DateTimeFormatter.ofPattern("M-d"))
    }
}

object monthday extends monthday
