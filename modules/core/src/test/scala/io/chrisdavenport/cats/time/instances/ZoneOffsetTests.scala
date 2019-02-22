package io.chrisdavenport.cats.time.instances

import java.time.ZoneOffset

import cats.tests.CatsSuite
import cats.kernel.laws.discipline.EqTests
import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.OrderTests
import TimeArbitraries._
import io.chrisdavenport.cats.time.instances.zoneoffset._

class ZoneOffsetTests extends CatsSuite {
  checkAll("ZoneOffset", EqTests[ZoneOffset].eqv)
  checkAll("ZoneOffset", HashTests[ZoneOffset].hash)
  checkAll("ZoneOffset", OrderTests[ZoneOffset].order)
}
