package io.chrisdavenport.cats.time.instances


import cats.tests.CatsSuite
import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.OrderTests
import TimeArbitraries._
import java.time.LocalDateTime
import io.chrisdavenport.cats.time.instances.hashWithOrder._

class LocalDateTimeTests extends CatsSuite {
  checkAll("LocalDateTime", HashTests[LocalDateTime].hash)
  checkAll("LocalDateTime", OrderTests[LocalDateTime].order)
}