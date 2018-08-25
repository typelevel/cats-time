package io.chrisdavenport.cats.time.instances

import cats._
import java.time.Duration

trait duration {

  implicit val durationInstances : Show[Duration] with Hash[Duration] with Order[Duration] = 
    new Show[Duration] with Hash[Duration] with Order[Duration]{
      override def hash(x: Duration): Int = x.hashCode
      override def compare(x: Duration, y: Duration): Int = x.compareTo(y)
      override def show(x: Duration): String = x.toString
    }
  
}

object duration extends duration