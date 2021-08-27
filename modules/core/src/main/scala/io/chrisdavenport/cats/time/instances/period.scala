package io.chrisdavenport.cats.time.instances

import cats._
import java.time.Period

trait period {
  implicit final val periodInstances: Show[Period] =
    new Show[Period] {
      override def show(x: Period): String = x.toString
    }
}

object period extends period

