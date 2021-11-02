package io.chrisdavenport.cats.time.instances

import java.time.Month

import cats.kernel.laws.discipline.{HashTests, OrderTests}
import io.chrisdavenport.cats.time.arb.TimeArbitraries._
import io.chrisdavenport.cats.time.instances.month._
import munit.DisciplineSuite

class MonthTests extends DisciplineSuite {
  checkAll("Month", HashTests[Month].hash)
  checkAll("Month", OrderTests[Month].order)
}
