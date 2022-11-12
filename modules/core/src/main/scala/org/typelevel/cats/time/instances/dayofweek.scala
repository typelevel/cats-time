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
import java.time.DayOfWeek
import java.time.format.TextStyle
import java.util.Locale

trait dayofweek {
  implicit final val dayofweekInstances: Show[DayOfWeek]
    with Order[DayOfWeek]
    with Hash[DayOfWeek] =
    new Show[DayOfWeek] with Order[DayOfWeek] with Hash[DayOfWeek] {
      override def hash(x: DayOfWeek): Int = x.hashCode
      override def compare(x: DayOfWeek, y: DayOfWeek): Int = x.compareTo(y)
      override def show(x: DayOfWeek): String = x.getDisplayName(TextStyle.FULL, Locale.ENGLISH)
    }
}

object dayofweek extends dayofweek
