package io.chrisdavenport.cats.time.instances

import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.OrderTests
import io.chrisdavenport.cats.time.arb.TimeArbitraries._
import io.chrisdavenport.cats.time.instances.instant._
import java.time.Instant
import munit.DisciplineSuite

class InstantTests extends DisciplineSuite {
  checkAll("Instant", HashTests[Instant].hash)
  checkAll("Instant", OrderTests[Instant].order)
}
