package io.chrisdavenport.cats.time.instances


import cats.tests.CatsSuite
import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.OrderTests
import java.time.YearMonth
import io.chrisdavenport.cats.time.instances.yearmonth._
import io.chrisdavenport.cats.time.arb.TimeArbitraries._

class YearMonthTests extends CatsSuite {
  checkAll("YearMonth", HashTests[YearMonth].hash)
  checkAll("YearMonth", OrderTests[YearMonth].order)
}
