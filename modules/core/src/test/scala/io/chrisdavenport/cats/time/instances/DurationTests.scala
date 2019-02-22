package io.chrisdavenport.cats.time.instances

import cats.tests.CatsSuite
import cats.kernel.laws.discipline.CommutativeMonoidTests
import cats.kernel.laws.discipline.EqTests
import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.OrderTests
import TimeArbitraries._
import java.time.Duration
import io.chrisdavenport.cats.time.instances.duration._

class DurationTests extends CatsSuite {
  checkAll("Duration", EqTests[Duration].eqv)
  checkAll("Duration", HashTests[Duration].hash)
  checkAll("Duration", OrderTests[Duration].order)
  checkAll("Duration", CommutativeMonoidTests[Duration].commutativeMonoid)
}
