package io.chrisdavenport.cats.time.instances

import java.time.YearMonth

import cats.tests.CatsSuite
import cats.kernel.laws.discipline.EqTests
import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.OrderTests
import TimeArbitraries._
import io.chrisdavenport.cats.time.instances.yearmonth._

class YearMonthTests extends CatsSuite {
  checkAll("YearMonth", EqTests[YearMonth].eqv)
  checkAll("YearMonth", HashTests[YearMonth].hash)
  checkAll("YearMonth", OrderTests[YearMonth].order)
}
