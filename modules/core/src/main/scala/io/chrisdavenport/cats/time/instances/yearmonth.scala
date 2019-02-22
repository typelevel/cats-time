package io.chrisdavenport.cats.time.instances

import cats._
import cats.implicits._
import java.time.YearMonth
import java.time.format.DateTimeFormatter

trait yearmonth {
  final def showYearMonth(formatter: DateTimeFormatter): Show[YearMonth] =
    Show[String].contramap(_.format(formatter))

  private final val yearMonthFormatter = DateTimeFormatter.ofPattern("yyyy-MM")

  implicit final val yearmonthInstances =
    new Show[YearMonth] with Order[YearMonth] with Hash[YearMonth] with Eq[YearMonth]{
      override def hash(x: YearMonth): Int = x.hashCode
      override def compare(x: YearMonth, y: YearMonth): Int = x.compareTo(y)
      override def show(x: YearMonth): String = x.format(yearMonthFormatter)
      override def eqv(x: YearMonth, y: YearMonth): Boolean = x.equals(y)
    }
}

object yearmonth extends yearmonth
