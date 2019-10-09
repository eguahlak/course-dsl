package dk.kalhauge.course.dsl

class Lecture(val week: Week, val title: String) {
  lateinit var timeSlot: TimeSlot
  val number = week.course.nextLectureNumber
  val code get() = if (number < 10) "0$number" else "$number"
  var note: String = ""
  var overview: String? = null
  val sections = mutableListOf<Section>()
  val resources = mutableListOf<Resource>()

  fun monday(interval: Pair<String,String>) { timeSlot = TimeSlot(WeekDay.MONDAY, interval) }
  fun tuesday(interval: Pair<String,String>) { timeSlot = TimeSlot(WeekDay.TUESDAY, interval) }
  fun wednesday(interval: Pair<String,String>) { timeSlot = TimeSlot(WeekDay.WEDNESDAY, interval) }
  fun thursday(interval: Pair<String,String>) { timeSlot = TimeSlot(WeekDay.THURSDAY, interval) }
  fun friday(interval: Pair<String,String>) { timeSlot = TimeSlot(WeekDay.FRIDAY, interval) }

  val header get() = title

  fun add(section: Section) { sections.add(section) }
  }

fun Week.lecture(title: String, build: Lecture.() -> Unit = {}): Lecture {
  val lecture = Lecture(this, title)
  val timeSlotIndex = this.lectures.size
  add(lecture)
  this.course.add(lecture)
  if (timeSlotIndex < this.course.timeSlots.size) lecture.timeSlot = this.course.timeSlots[timeSlotIndex]
  lecture.build()
  return lecture
  }

