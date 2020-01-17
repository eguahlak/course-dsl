package dk.kalhauge.course.dsl

enum class Term { SPRING, FALL }

class Semester(val year: Int, val term: Term) {
  override fun toString() = when (term) {
    Term.FALL -> "${year} fall"
    Term.SPRING -> "${year} spring"
    }
  }

fun spring(year: Int) =
    Semester(year, Term.SPRING)

fun fall(year: Int) =
    Semester(year, Term.FALL)

class Course(val title: String, val semester: Semester, val root: String) {
  var overview: String? = null
  val timeSlots = mutableListOf<TimeSlot>()

  val flows = mutableListOf<Flow>()
  var plan: String? = null
  val resources = mutableListOf<Resource>()

  val objectives = mutableListOf<Objective>()
  var objective: String? = "After the course the student will"

  val creditables = mutableListOf<Creditable>()
  var creditable: String? = null

  var exam: String? = null

  var lectureNumberOffset = 0
  var nextLectureNumber = lectureNumberOffset
  val lectures get() = flows.map { it.lectures }.flatten()

  fun add(resource: Resource) { resources.add(resource) }
  fun add(flow: Flow) { flows.add(flow) }
  fun add(creditable: Creditable) { creditables.add(creditable) }
  fun add(objective: Objective) { objectives.add(objective) }

  }

fun course(title: String, semester: Semester, root: String = "", build: Course.() -> Unit = {}): Course {
  val course = Course(title, semester, root)
  course.build()
  return course
  }
