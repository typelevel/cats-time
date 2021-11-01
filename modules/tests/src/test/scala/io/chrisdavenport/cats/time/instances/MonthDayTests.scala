package io.chrisdavenport.cats.time.instances

import java.time.MonthDay

import cats.kernel.laws.discipline.{ HashTests, OrderTests }
import io.chrisdavenport.cats.time.arb.TimeArbitraries._
import io.chrisdavenport.cats.time.instances.monthday._
import munit.DisciplineSuite

class MonthDayTests extends DisciplineSuite {
  checkAll("MonthDay", HashTests[MonthDay].hash)
  checkAll("MonthDay", OrderTests[MonthDay].order)
}
