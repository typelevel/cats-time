package io.chrisdavenport.cats.time.instances

import cats._
import cats.implicits._

import java.time.{
  Period,
  ZoneId
}


trait show {
  implicit final val zoneIdShow : Show[ZoneId] = Show[String].contramap(_.getId)


  implicit final val showPeriod : Show[Period] = Show.fromToString[Period]


}

object show extends show