package io.chrisdavenport.cats.time.instances


import cats.tests.CatsSuite
import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.OrderTests
import TimeArbitraries._
import java.time.LocalDate
import io.chrisdavenport.cats.time.instances.hashWithOrder._

class LocalDateTests extends CatsSuite {
  checkAll("LocalDate", HashTests[LocalDate].hash)
  checkAll("LocalDate", OrderTests[LocalDate].order)
}