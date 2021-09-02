package io.chrisdavenport.cats.time.instances


import cats.tests.CatsSuite
import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.OrderTests
import TimeArbitraries._
import java.time.Instant
import io.chrisdavenport.cats.time.instances.instant._

class InstantTests extends CatsSuite {
  checkAll("Instant", HashTests[Instant].hash)
  checkAll("Instant", OrderTests[Instant].order)
}