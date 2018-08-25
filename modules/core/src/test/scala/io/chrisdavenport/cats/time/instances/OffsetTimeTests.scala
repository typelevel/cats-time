package io.chrisdavenport.cats.time.instances


import cats.tests.CatsSuite
import cats.kernel.laws.discipline.HashTests
import cats.kernel.laws.discipline.OrderTests
import TimeArbitraries._
import java.time.OffsetTime
import io.chrisdavenport.cats.time.instances.hashWithOrder._

class OffsetTimeTests extends CatsSuite {
  checkAll("OffsetTime", HashTests[OffsetTime].hash)
  checkAll("OffsetTime", OrderTests[OffsetTime].order)
}