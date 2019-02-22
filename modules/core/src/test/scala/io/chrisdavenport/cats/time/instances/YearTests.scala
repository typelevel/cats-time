package io.chrisdavenport.cats.time.instances

import cats.tests.CatsSuite
import cats.kernel.laws.discipline.EqTests
import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.OrderTests
import TimeArbitraries._
import java.time.Year
import io.chrisdavenport.cats.time.instances.year._

class YearTests extends CatsSuite {
  checkAll("Year", EqTests[Year].eqv)
  checkAll("Year", HashTests[Year].hash)
  checkAll("Year", OrderTests[Year].order)
}
