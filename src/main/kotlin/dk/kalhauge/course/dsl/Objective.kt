package dk.kalhauge.course.dsl

enum class Taxonomi {
  KNOWLEDGE, COMPREHENSION, APPLICATION, ANALYSIS, SYNTHESIS, EVALUATION
  }
class Objective(val lecture: Lecture, val title: String)