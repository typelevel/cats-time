package io.chrisdavenport.cats.time.instances

import cats._

import java.time.{
  ZonedDateTime
}

trait hashWithOrder {

  implicit final val hashWithOrderZonedDateTime: Hash[ZonedDateTime] with Order[ZonedDateTime] =
    new Hash[ZonedDateTime] with Order[ZonedDateTime] {
      override def hash(x: ZonedDateTime): Int = x.hashCode
      override def compare(x: ZonedDateTime, y: ZonedDateTime): Int = x.compareTo(y)
    }

}

object hashWithOrder extends hashWithOrder