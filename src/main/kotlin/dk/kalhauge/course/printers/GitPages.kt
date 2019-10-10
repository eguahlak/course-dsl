package dk.kalhauge.course.printers

import dk.kalhauge.course.dsl.*
import kotlin.reflect.KClass

class GitHubPagesVisitor(val context: Context) : Visitor {
  fun gitWeekLink(week: Week): String {
    return if (week.active) "[${week.code}](week-${week.code}/info.md)" else week.code
    }

  fun resourceHeader(type: KClass<Resource>) = when (type) {
    SlideShowResource::class -> "Slides"
    RepositoryResource::class -> "Repositories"
    ExternalLinkResource::class -> "External links"
    else -> "Other resources"
    }

  fun taxonomiHeader(taxonomi: Taxonomi) = when (taxonomi) {
    Taxonomi.KNOWLEDGE -> "know"
    Taxonomi.COMPREHENSION -> "understand"
    Taxonomi.APPLICATION -> "master"
    Taxonomi.ANALYSIS -> "be able to analyse"
    Taxonomi.SYNTHESIS -> "be able to change"
    Taxonomi.EVALUATION -> "be able to evaluate"
    }

  fun activityHeader(type: ActivityType) = when (type) {
    ActivityType.READ -> "**Read**"
    ActivityType.WRITE -> "**Write**"
    ActivityType.WORK -> "**Do**"
    }

  fun printResources(title: String, list: List<Resource>) {
    if (list.isEmpty()) return
    with (context) {
      printLine("###", title)
      list.forEach { printLine("* [${it.title}](${it.link})",0) }
      printLine()
      }
    }

  override fun visit(course: Course) {
    val filename = "${course.root}/course-info.md"
    with (context) {
      open(filename)
      printLine("# ${course.title} - ${course.semester}")
      printLine(course.overview)
      printLine("## Plan")
      printLine(course.plan)
      course.flows.forEach { visit(it) }

      printLine("## Resources")
      printResources("Slides", course.resources.filter { it is SlideShowResource })
      printResources("Repositories", course.resources.filter { it is RepositoryResource })
      printResources("External links", course.resources.filter { it is ExternalLinkResource })

      printLine("## Assignments and Credits")
      printLine(course.creditable)
      printLine("| Title | Credits |", 0)
      printLine("| :---- | ------: |", 0)
      course.creditables.forEach {
        if (it is Link && it.active) printLine(" | [${it.title}](${it.link}) | ${it.credits} |", 0)
        else printLine("| ${it.title} | ${it.credits} |", 0)
        }
      printLine()
      printLine("## Exam")
      printLine(course.exam)
      close()
      }
    }

  override fun visit(week: Week) {
    val filename = "${week.flow.course.root}/week-${week.code}/info.md"
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
      //lecture.sections.forEach { visit(it) }
      printLine("### Learning objectives")
      printLine(lecture.objective)
      lecture.objectives.forEach {
        printLine("* ${taxonomiHeader(it.level)} ${it.title}", 0)
        }
      printLine()
      printLine("### Teaching and learning activities (${lecture.workLoad})")
      printLine(lecture.activity)
      lecture.activities.forEach {
        printLine("* (${it.load}) ${activityHeader(it.type)} ${it.title}", 0)
        }
      printLine()
      printLine("### Resources")
      lecture.resources.forEach {
        when (it) {
          is SlideShowResource -> printLine("* [${it.title}](../${it.link})", 0)
          else -> printLine("* [${it.title}](${it.link})", 0)
          }
        }
      printLine("", 0)
      }
    }

  override fun visit(flow: Flow) {
    with (context) {
      printLine("###", flow.title)
      printLine(flow.text)
      printLine("**Business skills**:", flow.skills)
      printLine("| Week  |  Day  | Time  | Subject | Load | Notes |", 0)
      printLine("| :---: | :---: | :---: |:------ | ----: | :---- |", 0)
      flow.lectures.forEach {
        printLine("| ${gitWeekLink(it.week)} | ${it.timeSlot} | ${it.code} ${it.title} | ${it.workLoad} | ${it.note} |", 0)
        }
      printLine()
      }
    flow.weeks.forEach { visit(it) }
    }

  }

