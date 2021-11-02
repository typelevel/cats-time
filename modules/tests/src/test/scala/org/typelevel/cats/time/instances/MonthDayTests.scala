package org.typelevel.cats.time.instances

import java.time.MonthDay

import cats.kernel.laws.discipline.{HashTests, OrderTests}
import org.typelevel.cats.time.arb.TimeArbitraries._
import org.typelevel.cats.time.instances.monthday._
import munit.DisciplineSuite

class MonthDayTests extends DisciplineSuite {
  checkAll("MonthDay", HashTests[MonthDay].hash)
  checkAll("MonthDay", OrderTests[MonthDay].order)
}
