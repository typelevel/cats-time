package org.typelevel.cats.time.instances

import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.OrderTests
import org.typelevel.cats.time.arb.TimeArbitraries._
import org.typelevel.cats.time.instances.zoneddatetime._
import java.time.ZonedDateTime
import munit.DisciplineSuite

class ZonedDateTimeTests extends DisciplineSuite {
  checkAll("ZonedDateTime", HashTests[ZonedDateTime].hash)
  checkAll("ZonedDateTime", OrderTests[ZonedDateTime].order)
}
