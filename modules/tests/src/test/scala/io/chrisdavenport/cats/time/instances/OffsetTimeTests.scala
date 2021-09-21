package io.chrisdavenport.cats.time.instances


import cats.tests.CatsSuite
import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.OrderTests
import java.time.OffsetTime
import io.chrisdavenport.cats.time.instances.offsettime._
import io.chrisdavenport.cats.time.instances.instant._
import io.chrisdavenport.cats.time.arb.TimeArbitraries._

class OffsetTimeTests extends CatsSuite {
  checkAll("OffsetTime", HashTests[OffsetTime].hash)
  checkAll("OffsetTime", OrderTests[OffsetTime].order)
}
