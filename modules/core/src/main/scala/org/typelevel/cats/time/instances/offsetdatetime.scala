/*
 * Copyright (c) 2018 Typelevel
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package org.typelevel.cats.time.instances

import cats._
import cats.implicits._
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME

trait offsetdatetime {
  final def showOffsetDateTime(formatter: DateTimeFormatter): Show[OffsetDateTime] =
    Show[String].contramap(_.format(formatter))

  implicit final val offsetdatetimeInstances: Show[OffsetDateTime]
    with Order[OffsetDateTime]
    with Hash[OffsetDateTime] =
    new Show[OffsetDateTime] with Order[OffsetDateTime] with Hash[OffsetDateTime] {
      override def hash(x: OffsetDateTime): Int = x.hashCode
      override def compare(x: OffsetDateTime, y: OffsetDateTime): Int = x.compareTo(y)
      override def show(x: OffsetDateTime): String = x.format(ISO_OFFSET_DATE_TIME)
    }
}

object offsetdatetime extends offsetdatetime
