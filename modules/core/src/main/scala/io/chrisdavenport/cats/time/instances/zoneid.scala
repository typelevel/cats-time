package io.chrisdavenport.cats.time.instances

import cats._
import java.time.ZoneId

trait zoneid {
  implicit final val zoneidInstances = 
    new Show[ZoneId]{
      override def show(x: ZoneId): String = x.getId
    }
}

object zoneid extends zoneid