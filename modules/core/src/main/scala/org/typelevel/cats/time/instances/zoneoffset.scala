package org.typelevel.cats.time.instances

import cats._
import java.time.ZoneOffset

trait zoneoffset {
  implicit final val zoneoffsetInstances: Show[ZoneOffset]
    with Order[ZoneOffset]
    with Hash[ZoneOffset] =
    new Show[ZoneOffset] with Order[ZoneOffset] with Hash[ZoneOffset] {
      override def hash(x: ZoneOffset): Int = x.hashCode
      override def compare(x: ZoneOffset, y: ZoneOffset): Int = x.compareTo(y)
      override def show(x: ZoneOffset): String = x.getId
    }
}

object zoneoffset extends zoneoffset
