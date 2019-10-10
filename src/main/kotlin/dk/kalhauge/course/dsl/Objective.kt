package dk.kalhauge.course.dsl

enum class Taxonomi {
  KNOWLEDGE, COMPREHENSION, APPLICATION, ANALYSIS, SYNTHESIS, EVALUATION
  }

class Objective(val lecture: Lecture, val title: String, val level: Taxonomi) {

  }

fun Lecture.objective(title: String, level: Taxonomi, build: Objective.() -> Unit = {}): Objective {
  val objective = Objective(this, title, level)
  objective.build()
  add(objective)
  return objective
  }

fun Lecture.knows(title: String, build: Objective.() -> Unit = {}) = objective(title, Taxonomi.KNOWLEDGE, build)
fun Lecture.understands(title: String, build: Objective.() -> Unit = {}) = objective(title, Taxonomi.COMPREHENSION, build)
fun Lecture.masters(title: String, build: Objective.() -> Unit = {}) = objective(title, Taxonomi.APPLICATION, build)
fun Lecture.analysis(title: String, build: Objective.() -> Unit = {}) = objective(title, Taxonomi.ANALYSIS, build)
fun Lecture.synthesis(title: String, build: Objective.() -> Unit = {}) = objective(title, Taxonomi.SYNTHESIS, build)
fun Lecture.evaluation(title: String, build: Objective.() -> Unit = {}) = objective(title, Taxonomi.EVALUATION, build)