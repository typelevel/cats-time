package io.chrisdavenport.cats.time.instances

import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.OrderTests
import io.chrisdavenport.cats.time.arb.TimeArbitraries._
import io.chrisdavenport.cats.time.instances.year._
import java.time.Year
import munit.DisciplineSuite

class YearTests extends DisciplineSuite {
  checkAll("Year", HashTests[Year].hash)
  checkAll("Year", OrderTests[Year].order)
}
