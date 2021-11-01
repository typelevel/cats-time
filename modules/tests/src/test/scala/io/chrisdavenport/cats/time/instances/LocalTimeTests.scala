package io.chrisdavenport.cats.time.instances

import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.OrderTests
import io.chrisdavenport.cats.time.arb.TimeArbitraries._
import io.chrisdavenport.cats.time.instances.localtime._
import java.time.LocalTime
import munit.DisciplineSuite

class LocalTimeTests extends DisciplineSuite {
  checkAll("LocalTime", HashTests[LocalTime].hash)
  checkAll("LocalTime", OrderTests[LocalTime].order)
}
