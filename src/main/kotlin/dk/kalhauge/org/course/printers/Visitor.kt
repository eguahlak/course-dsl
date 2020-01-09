package dk.kalhauge.org.course.printers

import dk.kalhauge.org.course.dsl.Course
import dk.kalhauge.org.course.dsl.Flow
import dk.kalhauge.org.course.dsl.Lecture
import dk.kalhauge.org.course.dsl.Week

interface Visitor {
  fun visit(course: Course)
  fun visit(week: Week)
  fun visit(lecture: Lecture)
  fun visit(flow: Flow)
  }