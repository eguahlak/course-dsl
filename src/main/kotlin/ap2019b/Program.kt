package ap2019b

import dk.kalhauge.course.dsl.*
//import dk.kalhauge.org.course.dsl.*
import dk.kalhauge.course.printers.FileContext
import dk.kalhauge.course.printers.GitHubPagesVisitor
import dk.kalhauge.util.anchorize

val slideRoot = "/Users/AKA/DatSoftLyngby/dat4sem2019fall-advanced-programming/slides"

fun main() {
  val course = course(
      "Avanceret Programmering",
      fall(2019),
      ""
  ) {
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
      A student shall have a minimum of 80 [credits](#${"Assignments and Credits".anchorize()}) to attend the exam.
      
      Exam questions (Work in Progress)
      
      Answer one of the following questions (WIP),
      You can use your projects for examples and discussions 
      
      1. Properties and classes
         - fields published as properties (Java)
         - properties backed by fields (Kotlin)
         - data classes and their use
         - sealed classes (Kotlin) and union types (Elm)
      1. Mutability
         - in inheriance `open` classes and functions
         - in properties `val` and `var`
         - in collections
         - in the perspective of functional programming
      1. Lambdas
         - what is a lambda
         - lambda type definitions (Kotlin/Elm) 
         - use of lambdas in collections
         - difference between collections and streams (Kotlin)
         - lambdas with receiver and DSLs
         - higher order functions
      1. Reflection
         - when to use reflection
         - example of reflection in use (Project)
         - determin which functions and/or properties an object has
         - calling a function on an object via reflection
      1. Coroutines
         - coroutines for iterators and sequences
         - coroutines for concurrency
         - (coroutine Channels and workers)
      1. Kotlin
         - properties
         - inheritance
         - null safety and smart casting
         - DSLs and extension functions
      1. Elm
         - explain the functional programming paradigm
         - types in Elm
         - Elm architecture
           - model, view, update
           - Elm runtime
         - Pros and Cons Elm vs. Javascript
      1. Android
         - lifecycle
         - Activities, layouts, and Views
         - event listeners
         - (Android and coroutines)
         - API's for Android: ANKO
      """.trimIndent()

  }
  GitHubPagesVisitor(
      FileContext(
          "/Users/AKA/DatSoftLyngby/dat4sem2019fall-advanced-programming/docs"
      )
  )
    .visit(course)
  // GitHubPagesVisitor(ConsoleContext()).visit(course)
  }