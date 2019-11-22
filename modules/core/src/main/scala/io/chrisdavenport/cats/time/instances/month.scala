package io.chrisdavenport.cats.time.instances

import cats._
import java.time.Month
import java.time.format.DateTimeFormatter

trait month {
  implicit final val monthInstances =
    new Show[Month] with Order[Month] with Hash[Month]{
      override def hash(x: Month): Int = x.hashCode
      override def compare(x: Month, y: Month): Int = x.compareTo(y)
      override def show(x: Month): String = DateTimeFormatter.ofPattern("MM").format(x)
    }
}

object month extends month
