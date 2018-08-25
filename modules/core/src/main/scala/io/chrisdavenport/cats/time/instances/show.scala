package io.chrisdavenport.cats.time.instances

import cats._
import cats.implicits._

import java.time.{
  ZoneId
}

trait show {
  implicit final val zoneIdShow : Show[ZoneId] = Show[String].contramap(_.getId)

}

object show extends show