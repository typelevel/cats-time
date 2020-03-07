package io.chrisdavenport.cats.time.instances

import cats._
import java.time.Period

trait period {
  implicit final val periodInstances: Show[Period] =
    (x: Period) => x.toString
}

object period extends period
