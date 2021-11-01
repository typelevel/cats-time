package io.chrisdavenport.cats.time.instances

import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.OrderTests
import io.chrisdavenport.cats.time.arb.TimeArbitraries._
import io.chrisdavenport.cats.time.instances.zoneddatetime._
import java.time.ZonedDateTime
import munit.DisciplineSuite

class ZonedDateTimeTests extends DisciplineSuite {
  checkAll("ZonedDateTime", HashTests[ZonedDateTime].hash)
  checkAll("ZonedDateTime", OrderTests[ZonedDateTime].order)
}
