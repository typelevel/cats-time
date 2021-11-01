package io.chrisdavenport.cats.time.instances

import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.OrderTests
import io.chrisdavenport.cats.time.arb.TimeArbitraries._
import io.chrisdavenport.cats.time.instances.offsetdatetime._
import java.time.OffsetDateTime
import munit.DisciplineSuite

class OffsetDateTimeTests extends DisciplineSuite {
  checkAll("OffsetDateTime", HashTests[OffsetDateTime].hash)
  checkAll("OffsetDateTime", OrderTests[OffsetDateTime].order)
}
