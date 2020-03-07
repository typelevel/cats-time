package io.chrisdavenport.cats.time.instances

import cats.tests.CatsSuite
import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.OrderTests
import TimeArbitraries._
import java.time.ZoneOffset
import io.chrisdavenport.cats.time.instances.zoneoffset._

class ZoneOffsetTests extends CatsSuite {
  checkAll("ZoneOffset", HashTests[ZoneOffset].hash)
  checkAll("ZoneOffset", OrderTests[ZoneOffset].order)
}
