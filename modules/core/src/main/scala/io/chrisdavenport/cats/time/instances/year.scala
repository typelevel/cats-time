package io.chrisdavenport.cats.time.instances

import cats._
import java.time.Year
import java.time.format.DateTimeFormatter

trait year {
  implicit final val yearInstances =
    new Show[Year] with Order[Year] with Hash[Year]{
      override def hash(x: Year): Int = x.hashCode
      override def compare(x: Year, y: Year): Int = x.compareTo(y)
      override def show(x: Year): String = x.format(DateTimeFormatter.ofPattern("yyyy"))
    }
}

object year extends year
