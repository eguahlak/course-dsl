package dk.kalhauge.course.printers

import dk.kalhauge.course.dsl.Course
import dk.kalhauge.course.dsl.Lecture
import dk.kalhauge.course.dsl.Section
import dk.kalhauge.course.dsl.Week

class GitHubPagesVisitor(val context: Context) : Visitor {
  fun gitWeekLink(week: Week): String {
    return if (week.active) "[${week.code}](week-${week.code}/info.md)" else week.code
    }
  fun categoryHeader(category: String) = when (category) {
    "slide" -> "Slides"
    "repo" -> "Repositories"
    "extern" -> "External links"
    "book" -> "Books"
    else -> category
    }

  override fun visit(course: Course) {
    val filename = "${course.root}/course-info.md"
    with (context) {
      open(filename)
      printLine("# ${course.title} - ${course.semester}")
      printLine(course.overview)
      printLine("## Plan")
      printLine(course.plan)
      printLine("| Week  |  No.  | Time  | Subject | Notes |", 0)
      printLine("| :---: | :---: | :---: |:------ | :---- |", 0)
      course.lectures.forEach {
        printLine("| ${gitWeekLink(it.week)} | ${it.code} | ${it.timeSlot} | ${it.title} | ${it.note} |", 0)
        }
      printLine("", 0)
      course.sections.forEach { visit(it) }
      course.weeks.forEach { visit(it) }
      printLine("## Resources")
      for ((category, list) in course.resources) {
        printLine("### ${categoryHeader(category)}")
        list.forEach {
          printLine("* [${it.title}](${it.link})")
          }
        }
      close()
      }
    }

  override fun visit(week: Week) {
    val filename = "${week.course.root}/week-${week.code}/info.md"
    with (context) {
      open(filename)
      printLine("# Week ${week.number} - ${week.header}")
      week.lectures.forEach { visit(it) }
      close()
      }
    }



  override fun visit(lecture: Lecture) {
    with (context) {
      if (lecture.header != lecture.week.header) printLine("## ${lecture.header}")
      lecture.sections.forEach { visit(it) }
      printLine("### Learning objectives")
      // TODO: Add objectives here
      printLine("### Teaching and learning activities (TLAs)")
      // TODO: Add teaching and learning activities here
      printLine("### Resources")
      lecture.resources.forEach {
        printLine("* [${it.title}](${it.link})", 0)
        }
      printLine("", 0)
      }
    }

  override fun visit(section: Section) {
    with (context) {
      printLine("### ${section.title}")
      printLine(section.text)
      }
    }
  }

