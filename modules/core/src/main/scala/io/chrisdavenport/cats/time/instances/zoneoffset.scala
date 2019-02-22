package io.chrisdavenport.cats.time.instances

import cats._
import java.time.ZoneOffset

trait zoneoffset {
  implicit final val zoneoffsetInstances =
    new Show[ZoneOffset] with Order[ZoneOffset] with Hash[ZoneOffset] with Eq[ZoneOffset]{
      override def hash(x: ZoneOffset): Int = x.hashCode
      override def compare(x: ZoneOffset, y: ZoneOffset): Int = x.compareTo(y)
      override def show(x: ZoneOffset): String = x.getId
      override def eqv(x: ZoneOffset, y: ZoneOffset): Boolean = x.equals(y)
    }
}

object zoneoffset extends zoneoffset
