package io.chrisdavenport.cats.time.instances


import cats.tests.CatsSuite
import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.EqTests
import java.time.ZoneId
import io.chrisdavenport.cats.time.instances.zoneid._
import io.chrisdavenport.cats.time.arb.TimeArbitraries._

class ZoneIdTests extends CatsSuite {
  checkAll("ZoneId", EqTests[ZoneId].eqv)
  checkAll("ZoneId", HashTests[ZoneId].hash)
}
