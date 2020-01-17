package dk.kalhauge.course.printers

import dk.kalhauge.course.dsl.Course
import dk.kalhauge.course.dsl.Flow
import dk.kalhauge.course.dsl.Lecture
import dk.kalhauge.course.dsl.Week

interface Visitor {
  fun visit(course: Course)
  fun visit(week: Week)
  fun visit(lecture: Lecture)
  fun visit(flow: Flow)
  }