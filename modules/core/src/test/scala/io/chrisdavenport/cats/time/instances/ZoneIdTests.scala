package io.chrisdavenport.cats.time.instances

import cats.tests.CatsSuite
import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.EqTests
import TimeArbitraries._
import java.time.ZoneId
import io.chrisdavenport.cats.time.instances.zoneid._

class ZoneIdTests extends CatsSuite {
  checkAll("ZoneId", EqTests[ZoneId].eqv)
  checkAll("ZoneId", HashTests[ZoneId].hash)
}
