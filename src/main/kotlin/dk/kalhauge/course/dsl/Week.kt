package dk.kalhauge.course.dsl

enum class WeekDay {
  MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
  }

class Week(val flow: Flow, val number: Int) {
  var active = false
  var title = ""
  val code get() = if (number < 10) "0${number}" else "$number"
  val lectures = mutableListOf<Lecture>()
  val header get() = when {
    title.isNotBlank() -> title
    lectures.size == 1 -> lectures[0].header
    flow.title != null -> flow.title
    else -> ""
    }

  fun add(lecture: Lecture) { lectures.add(lecture) }
  }

fun Flow.week(number: Int, build: Week.() -> Unit = {} ): Week {
  val week = Week(this, number)
  week.build()
  add(week)
  return week
  }