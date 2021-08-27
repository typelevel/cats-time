package io.chrisdavenport.cats.time.instances

import cats._
import java.time.Instant

trait instant {
  implicit final val instantInstances: Hash[Instant] with Order[Instant] with Show[Instant] =
    new Hash[Instant] with Order[Instant] with Show[Instant] {
      override def hash(x: Instant): Int = x.hashCode
      override def compare(x: Instant, y: Instant): Int = x.compareTo(y)
      override def show(x: Instant): String = x.toString
    }

}

object instant extends instant

