package io.chrisdavenport.cats.time.instances

import cats._
import java.time.ZoneId

trait zoneid {
  implicit final val zoneidInstances = 
    new Show[ZoneId] with Eq[ZoneId] with Hash[ZoneId]{
      override def eqv(x: ZoneId, y: ZoneId): Boolean = x.equals(y)
      override def hash(x: ZoneId): Int = x.hashCode
      override def show(x: ZoneId): String = x.getId
    }
}

object zoneid extends zoneid
