package io.chrisdavenport.cats.time.instances

import cats.kernel.laws.discipline.EqTests
import cats.kernel.laws.discipline.HashTests
import io.chrisdavenport.cats.time.arb.TimeArbitraries._
import io.chrisdavenport.cats.time.instances.zoneid._
import java.time.ZoneId
import munit.DisciplineSuite

class ZoneIdTests extends DisciplineSuite {
  checkAll("ZoneId", EqTests[ZoneId].eqv)
  checkAll("ZoneId", HashTests[ZoneId].hash)
}
