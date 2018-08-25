package io.chrisdavenport.cats.time.instances

import cats._
import java.time.Instant

trait instant {
  implicit val instantInstances = 
    new Show[Instant] with Hash[Instant] with Order[Instant]{
      override def hash(x: Instant): Int = x.hashCode
      override def compare(x: Instant, y: Instant): Int = x.compareTo(y)
      override def show(x: Instant): String = x.toString
    }
  
}

object instant extends instant