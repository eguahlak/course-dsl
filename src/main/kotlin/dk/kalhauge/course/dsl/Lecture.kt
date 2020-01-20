package dk.kalhauge.course.dsl

class Lecture(val week: Week, val title: String) {
  lateinit var timeSlot: TimeSlot
  val number = week.flow.course.nextLectureNumber++
  val code get() = if (number < 10) "0$number" else "$number"
  var note: String = ""
  var overview: String? = null
  // val sections = mutableListOf<Section>()
  val resources = mutableListOf<Resource>()
  var objective: String? = "After the lecture the student will"
  val objectives = mutableListOf<Objective>()
  var activity: String? = ""
  val activities = mutableListOf<Activity>()
  val load by lazy { activities.map { it.load }.sum() }
  val workLoad get() = if (load < 0.0001) "" else "$load"
  val dots = if (week.flow.course.root.isNullOrBlank()) "" else "../"

  fun monday(interval: Pair<String,String>) { timeSlot =
      TimeSlot(
          WeekDay.MONDAY,
          interval
      )
    }
  fun tuesday(interval: Pair<String,String>) { timeSlot =
      TimeSlot(
          WeekDay.TUESDAY,
          interval
      )
    }
  fun wednesday(interval: Pair<String,String>) { timeSlot =
      TimeSlot(
          WeekDay.WEDNESDAY,
          interval
      )
    }
  fun thursday(interval: Pair<String,String>) { timeSlot =
      TimeSlot(
          WeekDay.THURSDAY,
          interval
      )
    }
  fun friday(interval: Pair<String,String>) { timeSlot =
      TimeSlot(
          WeekDay.FRIDAY,
          interval
      )
    }

  val header get() = title

  // fun add(section: Section) { sections.add(section) }
  fun add(objective: Objective) {
    objectives.add(objective)
    if (objective.toFront) week.flow.course.add(objective)
    }
  fun add(resource: Resource) {
    resources.add(resource)
    if (resource.toFront) week.flow.course.add(resource)
    }
  fun add(activity: Activity) { activities.add(activity) }
  }

fun Week.lecture(title: String, build: Lecture.() -> Unit = {}): Lecture {
  val lecture = Lecture(this, title)
  val timeSlotIndex = this.lectures.size
  add(lecture)
  if (timeSlotIndex < this.flow.course.timeSlots.size) lecture.timeSlot = this.flow.course.timeSlots[timeSlotIndex]
  lecture.build()
  return lecture
  }

