package dk.kalhauge.org.course.dsl

enum class Taxonomi {
  KNOWLEDGE, COMPREHENSION, APPLICATION, ANALYSIS, SYNTHESIS, EVALUATION
  }

class Objective(val lecture: Lecture, val title: String, val level: Taxonomi, var toFront: Boolean) {

  }

fun Lecture.objective(title: String, level: Taxonomi, toFront: Boolean = false, build: Objective.() -> Unit = {}): Objective {
  val objective = Objective(this, title, level, toFront)
  objective.build()
  add(objective)
  return objective
  }

fun Lecture.knows(title: String, toFront: Boolean = false, build: Objective.() -> Unit = {}) =
    objective(title, Taxonomi.KNOWLEDGE, toFront, build)
fun Lecture.understands(title: String, toFront: Boolean = false, build: Objective.() -> Unit = {}) =
    objective(title, Taxonomi.COMPREHENSION, toFront, build)
fun Lecture.masters(title: String, toFront: Boolean = false, build: Objective.() -> Unit = {}) =
    objective(title, Taxonomi.APPLICATION, toFront, build)
fun Lecture.analysis(title: String, toFront: Boolean = false, build: Objective.() -> Unit = {}) =
    objective(title, Taxonomi.ANALYSIS, toFront, build)
fun Lecture.synthesis(title: String, toFront: Boolean = false, build: Objective.() -> Unit = {}) =
    objective(title, Taxonomi.SYNTHESIS, toFront, build)
fun Lecture.evaluation(title: String, toFront: Boolean = false, build: Objective.() -> Unit = {}) =
    objective(title, Taxonomi.EVALUATION, toFront, build)