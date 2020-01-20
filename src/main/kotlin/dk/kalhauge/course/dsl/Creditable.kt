package dk.kalhauge.course.dsl

interface Creditable {
  val title: String
  val credits: Double
  }

class Attendance(override val credits: Double) : Creditable {
  override var title = "Attendance"
  }

class Assignment(
    lecture: Lecture,
    title: String,
    val sourcePath: String,
    load: Double,
    override val credits: Double
    ) : Activity(lecture, title,
    ActivityType.WORK, load),
    Creditable, Link {
  var visible = true
  var text: String? = null // TODO: generate page if text != null
  override val active get() = link.isNotEmpty() && visible
  override val link = "resources/${sourcePath.substringAfterLast("/")}"
  }

fun Course.attendance(
    credits: Double = 20.0,
    build: Attendance.() -> Unit = {}
    ) = Attendance(credits).also {
  it.build()
  add(it)
  }

fun Lecture.assignment(
    title: String,
    sourcePath: String = "",
    load: Double = 0.0,
    credits: Double = 0.0,
    build: Assignment.() -> Unit = {}
    ) = Assignment(this, title, sourcePath, load, credits).also {
  it.build()
  add(it)
  week.flow.course.add(it)
  }