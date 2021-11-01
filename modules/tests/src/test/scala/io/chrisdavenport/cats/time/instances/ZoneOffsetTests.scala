package io.chrisdavenport.cats.time.instances

import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.OrderTests
import io.chrisdavenport.cats.time.arb.TimeArbitraries._
import io.chrisdavenport.cats.time.instances.zoneoffset._
import java.time.ZoneOffset
import munit.DisciplineSuite

class ZoneOffsetTests extends DisciplineSuite {
  checkAll("ZoneOffset", HashTests[ZoneOffset].hash)
  checkAll("ZoneOffset", OrderTests[ZoneOffset].order)
}
