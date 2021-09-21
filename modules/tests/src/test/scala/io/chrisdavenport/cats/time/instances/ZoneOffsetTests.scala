package io.chrisdavenport.cats.time.instances


import cats.tests.CatsSuite
import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.OrderTests
import java.time.ZoneOffset
import io.chrisdavenport.cats.time.instances.zoneoffset._
import io.chrisdavenport.cats.time.arb.TimeArbitraries._

class ZoneOffsetTests extends CatsSuite {
  checkAll("ZoneOffset", HashTests[ZoneOffset].hash)
  checkAll("ZoneOffset", OrderTests[ZoneOffset].order)
}
