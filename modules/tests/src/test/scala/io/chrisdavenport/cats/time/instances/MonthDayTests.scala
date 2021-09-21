package io.chrisdavenport.cats.time.instances

import java.time.MonthDay

import cats.kernel.laws.discipline.{ HashTests, OrderTests }
import cats.tests.CatsSuite
import io.chrisdavenport.cats.time.instances.monthday._
import io.chrisdavenport.cats.time.arb.TimeArbitraries._

class MonthDayTests extends CatsSuite {
  checkAll("MonthDay", HashTests[MonthDay].hash)
  checkAll("MonthDay", OrderTests[MonthDay].order)
}
