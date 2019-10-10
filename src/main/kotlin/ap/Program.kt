package ap

import dk.kalhauge.course.dsl.*
import dk.kalhauge.course.printers.FileContext
import dk.kalhauge.course.printers.GitHubPagesVisitor

fun main() {
  val course = course("Avanceret Programmering", fall(2019), "/AP") {
    tuesday(morning)
    wednesday(afternoon)
    overview = """
        There is a difference between developing APIs,
        developing programs, and using them.
        To develop effective and easy-to-use APIs,
        you need to take advantage of the advanced functionality of languages,
        such as coroutines, generics, reflection, lambdas, and streams.
        
        Functional programming has been given a renaissance
        as a strong component of major object-oriented languages
        such as Java, C # and now also Kotlin,
        not least because of the scalability with many cores and testability.
        Understanding this should therefore be included in a subject such as advanced programming.
        
        Another aspect of advanced programming is APIs for running multiple
        environments with different languages simultaneously and
        communicating between them.
        """.trimIndent()
    plan = """
      The main language will be Kotlin with detours for Java and C#.
      This is because Kotlin offers special mechanisms for building APIs
      including Domain Specific Languages (DSL), and Kotlin integrates 100% with Java.

      As a second language, Elm will be explained at the base level.
      We will create a Kotlin API, for running embedded Elm.
      In addition, Javascript will be integrated.
      """.trimIndent()
    kotlinFlow()
    elmFlow()
    androidFlow()

    attendance(20.0)

    exam = """
      30 minutes oral exam, no preparation but questions known in advance.
      """.trimIndent()
    }
  GitHubPagesVisitor(FileContext("/Users/AKA/DatSoftLyngby/dat4sem2019fall-advanced-programming/docs")).visit(course)
  // GitHubPagesVisitor(ConsoleContext()).visit(course)
  }