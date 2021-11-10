package org.typelevel.cats.time.instances

import cats._
import java.time.Duration

import cats.kernel.CommutativeMonoid

trait duration {
  implicit final val durationInstances: Show[Duration]
    with Hash[Duration]
    with Order[Duration]
    with CommutativeMonoid[Duration] =
    new Hash[Duration] with Order[Duration] with Show[Duration] with CommutativeMonoid[Duration] {
      override def hash(x: Duration): Int = x.hashCode
      override def compare(x: Duration, y: Duration): Int = x.compareTo(y)
      override def show(x: Duration): String = x.toString
      override def empty: Duration = Duration.ZERO
      override def combine(x: Duration, y: Duration): Duration = x.plus(y)
    }
}

object duration extends duration
