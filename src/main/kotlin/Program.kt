import dk.kalhauge.course.dsl.*
import dk.kalhauge.course.printers.ConsoleContext
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
    section("Kotlin") {
      +"""
        We will look at basis and the advanced topics of the programming language Kotlin.
        There will be examples on how the same or similar features are implemented in 
        languages as C#, Java, and JS.
      """.trimIndent()
      }
    section("Elm",
      """
        Elm is a ...
      """.trimIndent())
    section("Android") {
      +"""
        Kotlin has been selected by Google as the language for Android.
        We will have small detours to C and Arduinos (Node MCU’s)
      """.trimIndent()
      }
    week(34) {
      active = true
      lecture("Introduction") {
        objective = "To get an idea of the course content"
        slides("resources/00-kotlin.pdf")
        }
      }
    week(40) {
      active = true
      lecture("Basics") {
        comprehension("different implementations of properties")
        knowledge("the reason behind a restrictive code policy")
        slides("resources/01-basic-kotlin-handouts.pdf")
        }
      lecture("Variables, functions, and classes")
      }
    week(41) {
      active = true
      lecture("Lambdas, collections, and streams")
      lecture("Extension functions and DSL") {
        wednesday("13:00" to "16:00")
        note = "Remember internship fair"
        }
      }
    week(42) { title = "**Fall leave**" }
    week(43) {
      lecture("Reflection")
      lecture("Network with TCP and UDP sockets")
      }
    week(44) {
      title = "Coroutines"
      lecture("Build in coroutines")
      lecture("Custom coroutines")
      }
    week(45) {
      lecture("Assignment 1")
      }
    }
  GitHubPagesVisitor(FileContext("/Users/AKA/DatSoftLyngby/dat4sem2019fall-advanced-programming/docs")).visit(course)
  // GitHubPagesVisitor(ConsoleContext()).visit(course)
  }