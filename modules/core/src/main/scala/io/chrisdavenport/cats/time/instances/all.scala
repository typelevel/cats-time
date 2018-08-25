package io.chrisdavenport.cats.time.instances

trait all extends duration 
  with instant
  with localdate
  with hashWithOrder 
  with show

object all extends all