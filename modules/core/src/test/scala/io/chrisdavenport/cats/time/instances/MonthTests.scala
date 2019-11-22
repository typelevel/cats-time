package io.chrisdavenport.cats.time.instances

import java.time.Month

import cats.kernel.laws.discipline.{ HashTests, OrderTests }
import cats.tests.CatsSuite
import io.chrisdavenport.cats.time.instances.TimeArbitraries._
import io.chrisdavenport.cats.time.instances.month._

class MonthTests extends CatsSuite {
  checkAll("Month", HashTests[Month].hash)
  checkAll("Month", OrderTests[Month].order)
}
