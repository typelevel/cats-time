package org.typelevel.cats.time.instances

import java.time.Month

import cats.kernel.laws.discipline.{HashTests, OrderTests}
import org.typelevel.cats.time.arb.TimeArbitraries._
import org.typelevel.cats.time.instances.month._
import munit.DisciplineSuite

class MonthTests extends DisciplineSuite {
  checkAll("Month", HashTests[Month].hash)
  checkAll("Month", OrderTests[Month].order)
}
