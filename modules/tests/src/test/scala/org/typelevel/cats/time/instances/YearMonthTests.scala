package org.typelevel.cats.time.instances

import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.OrderTests
import org.typelevel.cats.time.arb.TimeArbitraries._
import org.typelevel.cats.time.instances.yearmonth._
import java.time.YearMonth
import munit.DisciplineSuite

class YearMonthTests extends DisciplineSuite {
  checkAll("YearMonth", HashTests[YearMonth].hash)
  checkAll("YearMonth", OrderTests[YearMonth].order)
}
