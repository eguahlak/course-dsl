package dk.kalhauge.course.dsl

class TimeSlot(val weekDay: WeekDay, val start: String, val end: String) {
  constructor(weekDay: WeekDay, interval: Pair<String, String>) : this(weekDay, interval.first, interval.second)
  val startText get() = if (start == "08:30" || start == "12:30") start else "**$start**"
  val endText get() = if (end == "12:00" || end == "16:00") end else "**$end**"
  override fun toString() = when (weekDay) {
    WeekDay.MONDAY -> "MO $startText-$endText"
    WeekDay.TUESDAY -> "TU $startText-$endText"
    WeekDay.WEDNESDAY -> "WE $startText-$endText"
    WeekDay.THURSDAY -> "TH $startText-$endText"
    WeekDay.FRIDAY -> "FR $startText-$endText"
    WeekDay.SATURDAY -> "**SA** $startText-$endText"
    WeekDay.SUNDAY -> "**SU** $startText-$endText"
    }
  }

val morning = "08:30" to "12:00"
val afternoon = "12:30" to "16:00"

fun Course.monday(interval: Pair<String,String>) { time(TimeSlot(WeekDay.MONDAY, interval)) }
fun Course.tuesday(interval: Pair<String,String>) { time(TimeSlot(WeekDay.TUESDAY, interval)) }
fun Course.wednesday(interval: Pair<String,String>) { time(TimeSlot(WeekDay.WEDNESDAY, interval)) }
fun Course.thursday(interval: Pair<String,String>) { time(TimeSlot(WeekDay.THURSDAY, interval)) }
fun Course.friday(interval: Pair<String,String>) { time(TimeSlot(WeekDay.FRIDAY, interval)) }

fun Course.time(timeSlot: TimeSlot) {
  timeSlots.add(timeSlot)
  }

