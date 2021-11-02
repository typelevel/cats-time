package org.typelevel.cats.time.instances

import cats.kernel.laws.discipline.EqTests
import cats.kernel.laws.discipline.HashTests
import org.typelevel.cats.time.arb.TimeArbitraries._
import org.typelevel.cats.time.instances.zoneid._
import java.time.ZoneId
import munit.DisciplineSuite

class ZoneIdTests extends DisciplineSuite {
  checkAll("ZoneId", EqTests[ZoneId].eqv)
  checkAll("ZoneId", HashTests[ZoneId].hash)
}
