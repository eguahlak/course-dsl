package dk.kalhauge.course.printers

import dk.kalhauge.course.dsl.*

interface Visitor {
  fun visit(course: Course)
  fun visit(week: Week)
  fun visit(lecture: Lecture)
  fun visit(flow: Flow)
  }