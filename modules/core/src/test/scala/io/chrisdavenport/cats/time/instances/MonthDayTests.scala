package io.chrisdavenport.cats.time.instances

import java.time.MonthDay

import cats.tests.CatsSuite
import cats.kernel.laws.discipline.EqTests
import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.OrderTests
import TimeArbitraries._
import io.chrisdavenport.cats.time.instances.monthday._

class MonthDayTests extends CatsSuite {
  checkAll("MonthDay", EqTests[MonthDay].eqv)
  checkAll("MonthDay", HashTests[MonthDay].hash)
  checkAll("MonthDay", OrderTests[MonthDay].order)
}
