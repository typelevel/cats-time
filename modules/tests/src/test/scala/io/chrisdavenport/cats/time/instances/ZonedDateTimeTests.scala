package io.chrisdavenport.cats.time.instances


import cats.tests.CatsSuite
import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.OrderTests
import java.time.ZonedDateTime
import io.chrisdavenport.cats.time.instances.zoneddatetime._
import io.chrisdavenport.cats.time.arb.TimeArbitraries._

class ZonedDateTimeTests extends CatsSuite {
  checkAll("ZonedDateTime", HashTests[ZonedDateTime].hash)
  checkAll("ZonedDateTime", OrderTests[ZonedDateTime].order)
}
