package io.chrisdavenport.cats.time.instances

import java.time.OffsetDateTime

import cats.tests.CatsSuite
import cats.kernel.laws.discipline.EqTests
import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.OrderTests
import TimeArbitraries._
import io.chrisdavenport.cats.time.instances.offsetdatetime._

class OffsetDateTimeTests extends CatsSuite {
  checkAll("OffsetDateTime", EqTests[OffsetDateTime].eqv)
  checkAll("OffsetDateTime", HashTests[OffsetDateTime].hash)
  checkAll("OffsetDateTime", OrderTests[OffsetDateTime].order)
}
