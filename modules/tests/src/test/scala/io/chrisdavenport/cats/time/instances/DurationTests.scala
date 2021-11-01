package io.chrisdavenport.cats.time.instances

import cats.kernel.laws.discipline.CommutativeMonoidTests
import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.OrderTests
import io.chrisdavenport.cats.time.arb.TimeArbitraries._
import io.chrisdavenport.cats.time.instances.duration._
import java.time.Duration
import munit.DisciplineSuite

class DurationTests extends DisciplineSuite {
  checkAll("Duration", HashTests[Duration].hash)
  checkAll("Duration", OrderTests[Duration].order)
  checkAll("Duration", CommutativeMonoidTests[Duration].commutativeMonoid)
}
