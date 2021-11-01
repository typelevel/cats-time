package io.chrisdavenport.cats.time.instances

import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.OrderTests
import io.chrisdavenport.cats.time.arb.TimeArbitraries._
import io.chrisdavenport.cats.time.instances.offsettime._
import java.time.OffsetTime
import munit.DisciplineSuite

class OffsetTimeTests extends DisciplineSuite {
  checkAll("OffsetTime", HashTests[OffsetTime].hash)
  checkAll("OffsetTime", OrderTests[OffsetTime].order)
}
