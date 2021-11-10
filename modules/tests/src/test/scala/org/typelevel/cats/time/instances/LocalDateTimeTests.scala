package org.typelevel.cats.time.instances

import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.OrderTests
import org.typelevel.cats.time.arb.TimeArbitraries._
import org.typelevel.cats.time.instances.localdatetime._
import java.time.LocalDateTime
import munit.DisciplineSuite

class LocalDateTimeTests extends DisciplineSuite {
  checkAll("LocalDateTime", HashTests[LocalDateTime].hash)
  checkAll("LocalDateTime", OrderTests[LocalDateTime].order)
}
