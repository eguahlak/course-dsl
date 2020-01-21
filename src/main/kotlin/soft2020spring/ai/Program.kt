package soft2020spring.ai

import dk.kalhauge.course.dsl.*
import dk.kalhauge.course.printers.FileContext
import dk.kalhauge.course.printers.GitHubPagesVisitor
import dk.kalhauge.util.anchorize

val slideRoot = "/Users/tdi/Documents/Teaching/AI/2020/Presentations/"

fun main() {
  val course = course("Artificial Intelligence", spring(2020), root = "AI/")
  {
      // tuesday(morning)
      wednesday(afternoon)
      overview = """
        This cource ...
        """.trimIndent()

      plan = """
      The course content is divided into three main streams: Artificial Intelligence, Machine Learning, and Deep Learning. ...
      """.trimIndent()

      aiFlow()
      flow("AI")
      {
        week(5)
        {
          lecture("Introduction to AI")
        }
      }

      mlFlow()
      flow("ML")
      {
        week(7)
        {
          lecture("Supoervised ML")
        }
      }

      dlFlow()
      flow("DL")
      {
        week(11)
        {
          lecture("Introduction to AI")
        }
      }
      // attendance(20.0)

      exam = """
      Oral exam, based on a group exam project.
      A student must have collected a minimum of 80 [credits](#${"Assignments and Credits".anchorize()}) during the semester to attend the exam.
      """.trimIndent()
  }

  GitHubPagesVisitor(
    FileContext("/Users/tdi/Documents/GitHub/soft2020spring/docs"))
    .visit(course)
  // GitHubPagesVisitor(ConsoleContext()).visit(course)
  }