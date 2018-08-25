package io.chrisdavenport.cats.time.instances

trait all extends duration 
  with instant
  with localdate
  with localdatetime
  with localtime
  with offsetdatetime
  with offsettime
  with yearmonth
  with zoneddatetime
  with show

object all extends all