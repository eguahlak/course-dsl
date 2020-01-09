package dk.kalhauge.org.course.dsl

class Flow(val course: Course, var title: String?) {
  var text: String? = null
  var skills: String? = null
  val weeks = mutableListOf<Week>()

  val lectures get() = weeks.map { it.lectures }.flatten()
  fun add(week: Week) { weeks.add(week) }
  }

fun Course.flow(title: String? = null, build: Flow.() -> Unit = {}): Flow {
  val flow = Flow(this, title)
  this.add(flow)
  flow.build()
  return flow
  }

