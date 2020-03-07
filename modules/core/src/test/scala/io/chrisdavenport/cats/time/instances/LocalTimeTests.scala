package io.chrisdavenport.cats.time.instances

import cats.tests.CatsSuite
import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.OrderTests
import TimeArbitraries._
import java.time.LocalTime
import io.chrisdavenport.cats.time.instances.localtime._

class LocalTimeTests extends CatsSuite {
  checkAll("LocalTime", HashTests[LocalTime].hash)
  checkAll("LocalTime", OrderTests[LocalTime].order)
}
