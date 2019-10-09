package dk.kalhauge.course.dsl

enum class Term { SPRING, FALL }

class Semester(val year: Int, val term: Term) {
  override fun toString() = when (term) {
    Term.FALL -> "${year} fall"
    Term.SPRING -> "${year} spring"
    }
  }

fun spring(year: Int) = Semester(year, Term.SPRING)

fun fall(year: Int) = Semester(year, Term.FALL)

class Course(val title: String, val semester: Semester, val root: String) {
  var lectureOffset = 0
  var overview: String? = null
  val weeks = mutableListOf<Week>()
  val lectures = mutableListOf<Lecture>()
  val nextLectureNumber: Int get() = lectures.size + lectureOffset
  val timeSlots = mutableListOf<TimeSlot>()
  val sections = mutableListOf<Section>()
  var plan: String? = null
  val resources = mutableMapOf<String,MutableList<Resource>>()

  fun add(resource: Resource) {
    if (!resources.containsKey(resource.category)) resources[resource.category] = mutableListOf<Resource>()
    resources[resource.category]?.add(resource)
    // TODO: Check for duplicates
    }
  fun add(week: Week) { weeks.add(week) }
  fun add(lecture: Lecture) { lectures.add(lecture) }
  fun add(section: Section) { sections.add(section) }
  }

fun course(title: String, semester: Semester, root: String = "", build: Course.() -> Unit = {}): Course {
  val course = Course(title, semester, root)
  course.build()
  return course
  }
