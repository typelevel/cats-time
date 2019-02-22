package io.chrisdavenport.cats.time.instances

import cats._
import java.time.Instant

trait instant {
  implicit final val instantInstances =
    new Hash[Instant] with Order[Instant] with Show[Instant] with Eq[Instant] {
      override def hash(x: Instant): Int = x.hashCode
      override def compare(x: Instant, y: Instant): Int = x.compareTo(y)
      override def show(x: Instant): String = x.toString
      override def eqv(x: Instant, y: Instant) = x.equals(y)
    }

}

object instant extends instant
