package io.chrisdavenport.cats.time.instances


import cats.tests.CatsSuite
import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.OrderTests
import java.time.OffsetDateTime
import io.chrisdavenport.cats.time.instances.offsetdatetime._
import io.chrisdavenport.cats.time.arb.TimeArbitraries._

class OffsetDateTimeTests extends CatsSuite {
  checkAll("OffsetDateTime", HashTests[OffsetDateTime].hash)
  checkAll("OffsetDateTime", OrderTests[OffsetDateTime].order)
}
