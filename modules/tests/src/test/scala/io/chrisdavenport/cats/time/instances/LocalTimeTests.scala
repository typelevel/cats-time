package io.chrisdavenport.cats.time.instances


import cats.tests.CatsSuite
import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.OrderTests
import java.time.LocalTime
import io.chrisdavenport.cats.time.instances.localtime._
import io.chrisdavenport.cats.time.arb.TimeArbitraries._

class LocalTimeTests extends CatsSuite {
  checkAll("LocalTime", HashTests[LocalTime].hash)
  checkAll("LocalTime", OrderTests[LocalTime].order)
}
