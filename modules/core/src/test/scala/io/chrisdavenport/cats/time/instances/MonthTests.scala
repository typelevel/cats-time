package io.chrisdavenport.cats.time.instances

import cats.tests.CatsSuite
import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.OrderTests
import TimeArbitraries._
import java.time.Month
import io.chrisdavenport.cats.time.instances.month._

class MonthTests extends CatsSuite {
  checkAll("Month", HashTests[Month].hash)
  checkAll("Month", OrderTests[Month].order)
  assert(Month.of(2).show == "02")
}
