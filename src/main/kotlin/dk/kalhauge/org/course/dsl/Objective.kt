package dk.kalhauge.org.course.dsl

enum class Taxonomy {
  KNOWLEDGE, ABILITY, SKILL/*, ANALYSIS, SYNTHESIS, EVALUATION */
  }

class Objective(val lecture: Lecture, val title: String, val level: Taxonomy, var toFront: Boolean) {

  }

fun Lecture.objective(title: String, level: Taxonomy, toFront: Boolean = false, build: Objective.() -> Unit = {}): Objective {
  val objective = Objective(this, title, level, toFront)
  objective.build()
  add(objective)
  return objective
  }

fun Lecture.knowledge(title: String, toFront: Boolean = false, build: Objective.() -> Unit = {}) =
    objective(title, Taxonomy.KNOWLEDGE, toFront, build)
fun Lecture.ability(title: String, toFront: Boolean = false, build: Objective.() -> Unit = {}) =
    objective(title, Taxonomy.ABILITY, toFront, build)
fun Lecture.skill(title: String, toFront: Boolean = false, build: Objective.() -> Unit = {}) =
    objective(title, Taxonomy.SKILL, toFront, build)

/*
fun Lecture.analysis(title: String, toFront: Boolean = false, build: Objective.() -> Unit = {}) =
    objective(title, Taxonomy.ANALYSIS, toFront, build)
fun Lecture.synthesis(title: String, toFront: Boolean = false, build: Objective.() -> Unit = {}) =
    objective(title, Taxonomy.SYNTHESIS, toFront, build)
fun Lecture.evaluation(title: String, toFront: Boolean = false, build: Objective.() -> Unit = {}) =
    objective(title, Taxonomy.EVALUATION, toFront, build)
*/