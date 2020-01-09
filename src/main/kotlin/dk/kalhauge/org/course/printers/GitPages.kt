package dk.kalhauge.org.course.printers

import dk.kalhauge.org.course.dsl.*
import dk.kalhauge.util.anchorize
import dk.kalhauge.util.nice
import kotlin.reflect.KClass

class GitHubPagesVisitor(val context: Context) :
  Visitor {
  fun gitWeekLink(week: Week) =
      if (week.active) "[${week.code}](week-${week.code}/info.md)" else week.code

  fun gitLectureLink(lecture: Lecture) =
      if (lecture.week.active) "${lecture.code} [${lecture.title}](week-${lecture.week.code}/info.md#${lecture.title.anchorize()})"
      else "${lecture.code} ${lecture.title}"

  fun resourceHeader(type: KClass<Resource>) = when (type) {
    SlideShowResource::class -> "Slides"
    RepositoryResource::class -> "Repositories"
    ExternalLinkResource::class -> "External links"
    else -> "Other resources"
    }

  fun taxonomiHeader(taxonomi: Taxonomi) = when (taxonomi) {
    Taxonomi.KNOWLEDGE -> "_know_"
    Taxonomi.COMPREHENSION -> "_understand_"
    Taxonomi.APPLICATION -> "_master_"
    Taxonomi.ANALYSIS -> "be able to _analyse_"
    Taxonomi.SYNTHESIS -> "be able to _build_"
    Taxonomi.EVALUATION -> "be able to _evaluate_"
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
    val onlyCourseInRepo = course.root.isBlank()
    val filename = if (onlyCourseInRepo) "README.md" else "${course.root}course-info.md"
    with (context) {
      open(filename)
      if (!onlyCourseInRepo) printLine("# ${course.title} - ${course.semester}")
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
      val creditables = course.creditables
      val sum = creditables.map { it.credits }.sum()
      course.creditables.forEach {
        if (it is Link && it.active) printLine(" | [${it.title}](${it.link}) | ${it.credits} |", 0)
        else printLine("| ${it.title} | ${it.credits} |", 0)
        }
      if (sum < 100.0) {
        printLine("| Assignments | ${100.0 - sum} |", 0)
        }
      printLine()
      printLine("## Main objectives")
      printLine(course.objective)
      val objectives = course.objectives
      if (objectives.size == 0) {
        printLine("* Main objectives will show here")
        }
      objectives.forEach {
        printLine("* ${taxonomiHeader(it.level)} ${it.title}", 0)
        }
      printLine()
      printLine("## Exam")
      printLine(course.exam)
      close()
      }
    createSummaryPage(course)
    }

  override fun visit(week: Week) {
    val filename = "${week.flow.course.root}week-${week.code}/info.md"
    with (context) {
      open(filename)
      printLine("# Week ${week.number} - ${week.header}")
      printLine(week.overview)
      week.lectures.forEach { visit(it) }
      close()
      }
    }

  override fun visit(lecture: Lecture) {
    with (context) {
      if (lecture.header != lecture.week.header) printLine("## ${lecture.header}")
      printLine(lecture.overview)
      printLine("### Learning objectives")
      printLine(lecture.objective)
      lecture.objectives.forEach {
        printLine("* ${taxonomiHeader(it.level)} ${it.title}", 0)
        }
      printLine()
      printLine("### Teaching and learning activities (${lecture.workLoad})")
      printLine(lecture.activity)
      lecture.activities.forEach {
        when (it) {
          is Assignment -> {
            if (it.sourcePath.isNotBlank()) {
              updateFile(it.sourcePath, it.link)
              printLine("* (${it.load}) ${activityHeader(it.type)} [${it.title}](../${it.link})", 0)
              }
            else printLine("* (${it.load}) ${activityHeader(it.type)} ${it.title}", 0)
            }
          else -> printLine("* (${it.load}) ${activityHeader(it.type)} ${it.title}", 0)
          }
        }
      printLine()
      printLine("### Resources")
      lecture.resources.forEach {
        when (it) {
          is SlideShowResource -> {
            updateFile(it.sourcePath, it.link)
            printLine("* [${it.title}](../${it.link})", 0)
            }
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
      val lectures = flow.lectures
      if (lectures.size > 0) {
        printLine("| Week  |  Day  | Time  | Subject | Load | Notes |", 0)
        printLine("| :---: | :---: | :---: |:------ | ----: | :---- |", 0)
        lectures.forEach {
          printLine(
              "| ${gitWeekLink(it.week)} | ${it.timeSlot} | ${gitLectureLink(it)}  | ${it.workLoad} | ${it.note} |",
              0
              )
          }
        printLine()
        }
      }
    flow.weeks.forEach { visit(it) }
    }

  fun createSummaryPage(course: Course) {
    val filename = "${course.root}summary.md"
    with (context) {
      open(filename)
      printLine("# Summary page")

      printLine("## Credits")
      printLine("| Title | Credits |", 0)
      printLine("| :---- | ------: |", 0)
      course.creditables.forEach {
        if (it is Link && it.active) printLine(" | [${it.title}](${it.link}) | ${it.credits} |", 0)
        else printLine("| ${it.title} | ${it.credits} |", 0)
        }
      printLine("| **Total** | **${course.creditables.map { it.credits }.sum()}** |")

      printLine("## Learning objectives")
      printLine("| Level | Objective | Lecture |", 0)
      printLine("| ----: | :-------- | :-----: |", 0)
      course.lectures.flatMap { it.objectives }.forEach {
        if (it.toFront) printLine("| **${taxonomiHeader(it.level)}** | **${it.title}** | ${it.lecture.number}", 0)
        else printLine("| ${taxonomiHeader(it.level)} | ${it.title} | ${it.lecture.number}", 0)
        }
      printLine()

      printLine("### Knowledge (Viden)")
      course.lectures.flatMap { it.objectives }.filter {it.level == Taxonomi.KNOWLEDGE} .forEach {
        if (it.toFront) printLine("* **${taxonomiHeader(it.level)} ${it.title}**", 0)
        else printLine("* ${taxonomiHeader(it.level)} ${it.title}", 0)
        }
      printLine()
      printLine("### Abilities (Færdigheder)")
      course.lectures.flatMap { it.objectives }.filter {it.level == Taxonomi.COMPREHENSION} .forEach {
        if (it.toFront) printLine("* **${taxonomiHeader(it.level)} ${it.title}**", 0)
        else printLine("* ${taxonomiHeader(it.level)} ${it.title}", 0)
        }
      printLine()
      printLine("### Skills (Kompetencer)")
      val skillTaxonomies = listOf(Taxonomi.APPLICATION, Taxonomi.EVALUATION, Taxonomi.SYNTHESIS, Taxonomi.ANALYSIS)
      course.lectures.flatMap { it.objectives }
        .filter { it.level in skillTaxonomies }
        .forEach {
        if (it.toFront) printLine("* **${taxonomiHeader(it.level)} ${it.title}**", 0)
        else printLine("* ${taxonomiHeader(it.level)} ${it.title}", 0)
        }
      printLine()

      printLine("## Work load")
      printLine("| Read | Write | Work |  All | Lecture |", 0)
      printLine("| ---: | ----: | ---: | ---: | :------ |", 0)
      var readTotal = 0.0
      var writeTotal = 0.0
      var workTotal = 0.0
      course.lectures.forEach {
        val r = it.activities.filter { it.type == ActivityType.READ }.map { it.load }.sum()
        val w = it.activities.filter { it.type == ActivityType.WRITE }.map { it.load }.sum()
        val d = it.activities.filter { it.type == ActivityType.WORK }.map { it.load }.sum()
        printLine("| ${nice(r)} | ${nice(w)} | ${nice(d)} | ${nice(r + w + d)} | ${gitLectureLink(it)} |", 0)
        readTotal += r
        writeTotal += w
        workTotal += d
        }
      val lectureCount = course.nextLectureNumber - 1
      val total = readTotal + writeTotal + workTotal
      printLine("| **$readTotal** | **$writeTotal** | **$workTotal** | **$total** | + ${lectureCount}\\*3.5 = _**${lectureCount*3.5 + total}**_ |")

      printLine("## Business skills")
      course.flows.forEach {
        printLine( "**${it.title}**: ", it.skills)
        }
      close()
      }
    }

  }

