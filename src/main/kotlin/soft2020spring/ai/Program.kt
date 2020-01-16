package soft2020spring.ai

import dk.kalhauge.org.course.dsl.*
import dk.kalhauge.org.course.printers.FileContext
import dk.kalhauge.org.course.printers.GitHubPagesVisitor
import dk.kalhauge.util.anchorize

val slideRoot = "/Users/tdi/Documents/Teaching/AI/2020/Presentations/"

fun main() {
  val course = course("Artificial Intelligence", spring(2020), root = "AI/" ) {
    // tuesday(morning)
    wednesday(afternoon)
    overview = """
        Hi Dora, do you know:
        There is a difference between developing APIs,
        developing programs, and using them.
        
        ...
        
        """.trimIndent()
    plan = """
      The main language will be Kotlin with detours for Java and C#.
      This is because Kotlin offers special mechanisms for building APIs
      including Domain Specific Languages (DSL), and Kotlin integrates 100% with Java.

      """.trimIndent()
    aiFlow()

    // attendance(20.0)

    exam = """
      30 minutes oral exam, no preparation but questions known in advance.
      A student shall have a minimum of 80 [credits](#${"Assignments and Credits".anchorize()}) to attend the exam.
      """.trimIndent()
  }
  GitHubPagesVisitor(FileContext( "/Users/tdi/Documents/GitHub/soft2020spring/docs"))
    .visit(course)
  // GitHubPagesVisitor(ConsoleContext()).visit(course)
  }