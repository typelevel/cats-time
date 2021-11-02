package io.chrisdavenport.cats.time.instances

trait all
    extends duration
    with instant
    with localdate
    with localdatetime
    with localtime
    with monthday
    with offsetdatetime
    with offsettime
    with period
    with year
    with yearmonth
    with zoneddatetime
    with zoneid
    with zoneoffset

trait all2 extends month

object all extends all with all2
