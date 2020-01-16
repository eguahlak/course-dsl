package soft2020spring.alg

import dk.kalhauge.org.course.dsl.*
import dk.kalhauge.org.course.printers.FileContext
import dk.kalhauge.org.course.printers.GitHubPagesVisitor
import dk.kalhauge.util.anchorize

val slideRoot = "/Users/AKA/DatSoftLyngby/soft2020spring/ALG/slides"

fun main() {
  val course = course("Algorithms and Datastructures", spring(2020), root = "ALG/") {
    wednesday(morning)
    overview = """
        Algorithms are ...
        """.trimIndent()
    plan = """
      ALG is structured in ...
      """.trimIndent()
    sortingFlow()
    flow("Graphs") {
      week(9) {
        lecture("Deikstra")
        }
      }

    // attendance(20.0)

    exam = """
      30 minutes oral exam, no preparation but questions known in advance.
      A student shall have a minimum of 80 [credits](#${"Assignments and Credits".anchorize()}) to attend the exam.
      """.trimIndent()
  }
  GitHubPagesVisitor(FileContext("/Users/AKA/DatSoftLyngby/soft2020spring/docs"))
    .visit(course)
  // GitHubPagesVisitor(ConsoleContext()).visit(course)
  }