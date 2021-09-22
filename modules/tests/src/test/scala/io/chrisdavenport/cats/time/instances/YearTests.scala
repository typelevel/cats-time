package io.chrisdavenport.cats.time.instances

import cats.tests.CatsSuite
import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.OrderTests
import java.time.Year
import io.chrisdavenport.cats.time.instances.year._
import io.chrisdavenport.cats.time.arb.TimeArbitraries._

class YearTests extends CatsSuite {
  checkAll("Year", HashTests[Year].hash)
  checkAll("Year", OrderTests[Year].order)
}
