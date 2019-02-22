package io.chrisdavenport.cats.time.instances

import java.time.OffsetTime

import cats.tests.CatsSuite
import cats.kernel.laws.discipline.EqTests
import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.OrderTests
import TimeArbitraries._
import io.chrisdavenport.cats.time.instances.offsettime._

class OffsetTimeTests extends CatsSuite {
  checkAll("OffsetTime", EqTests[OffsetTime].eqv)
  checkAll("OffsetTime", HashTests[OffsetTime].hash)
  checkAll("OffsetTime", OrderTests[OffsetTime].order)
}
