package io.chrisdavenport.cats.time.instances

import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.OrderTests
import io.chrisdavenport.cats.time.arb.TimeArbitraries._
import io.chrisdavenport.cats.time.instances.localdate._
import java.time.LocalDate
import munit.DisciplineSuite

class LocalDateTests extends DisciplineSuite {
  checkAll("LocalDate", HashTests[LocalDate].hash)
  checkAll("LocalDate", OrderTests[LocalDate].order)
}
