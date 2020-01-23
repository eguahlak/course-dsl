package ap2019b

import dk.kalhauge.course.dsl.*
// import dk.kalhauge.org.course.dsl.*
import dk.kalhauge.util.image

fun Course.kotlinFlow() = flow("Kotlin") {
  text = """
      We will look at basis and the advanced topics of the programming language Kotlin.
      There will be examples on how the same or similar features are implemented in 
      languages as C#, Java, and JS.
      """.trimIndent()
  skills = """
      Learning a new language is an important skill in an ever changing world.
      Also Kotlin has taken the best from most programming paradigms,
      knowing these and being able to relate them to other programming languages is a spoken for skill.
      """.trimIndent()
  week(34) {
    active = true
    lecture("Introduction") {
      objective = "To get an idea of the course content"
      // slideShow("resources/00-kotlin.pdf")
      presentation("$slideRoot/00-course-description/00-kotlin.pdf")
      }
    }
  week(40) {
    active = true
    lecture("Basics") {
      skill("which programming language to choose for an application", true)
      ability("different implementations of properties")
      knowledge("the reason behind a restrictive code policy")
      ability("pros and cons of the structured programming paradigm", true)

      read("`Basics` chapter in Kotlin reference", 3.0)
      work("Install IntelliJ IDE", 2.0)
      work("expected selfstudy", 1.0)

      //slideShow("resources/01-basic-kotlin-handouts.pdf")
      presentation("$slideRoot/01-basic-kotlin/01-basic-kotlin-handouts.pdf")
      repository("https://github.com/datsoftlyngby/dat4sem2019fall-advanced-programming-code.git")
      externalLink("https://kotlinlang.org/docs/kotlin-docs.pdf") {
        toFront = true
        title = "Kotlin Language Documentation"
        }
      externalLink("https://kotlinlang.org/docs/reference/") {
        toFront = true
        title = "Kotlin Reference"
        }
      }
    lecture("Variables, functions, and classes") {
      ability("the difference between relations and references")
      skill("creation of classes and objects in Kotlin")
      ability("custom properties and delegated properties")
      ability("pros and cons of the object oriented programming language paradigm")

      read("`Classes and Objects` chapter in Kotlin reference", 2.0)
      work("work on exercise", 4.0)
      work("expected selfstudy", 1.0)
      }
    }
  week(41) {
    active = true

    lecture("Lambdas, collections, and streams") {
      ability("functions as first class citizens", true)
      knowledge("the difference between functions, methods, and procedures")
      knowledge("the properties of collections and streams, and their differences")

      read("`Functions and Lambdas` and `Collection` chapters from Kotlin reference", 3.5)
      work("expected selfstudy", 2.0)
      }

    lecture("Extension functions and DSL") {
      wednesday("13:00" to "16:00")
      note = "Internship fair"

      overview = """
          **Exercise**: Create a DSL that can specify data structures for a homepage in html or markdown.
          It could be a homepage for a Chorus as described in UML here:
          
          ${image("04-exercise.png")}
          
          The following code snippet gives an idea:
          ```kotlin
          class Member(val firstName: String) {
            var email = ""
            // ...
            }
            
          fun Choir.member(firstName: String, build: Member.() -> Unit = {}): Member {
            val member = Member(firstName)
            member.build()
            return member
            }
          ```
          The `member` function can be written even more compact with:
          ```kotlin
          fun Choir.member(firstName: String, build: Member.() -> Unit = {}) = Member(firstName).also { it.build() }
          ```
          The function should be called in a `Choir` context as in:
          ```kotlin
          val choir = choir("Firmakoret") {
            member("Kurt") {
              email = "kurt@hansen.dk"
              }
            // ...
            }
          ```
          """.trimIndent()
      ability("Extension functions and extension lambdas")
      skill("Kotlin programming language", true)
      skill("building a DSL from the buttom up using extension functions and lambdas")

      read("`Functional Programming` from Kotlin for Py", 3.0)
      work("Chorus (or similar) DSL exercise", 5.0)

      externalLink("https://kotlinlang.org/docs/tutorials/kotlin-for-py/introduction.html") {
        toFront = true
        title = "Kotlin for Py"
        }
      repository("https://github.com/eguahlak/course-dsl.git")
      }
    }
  week(42) { title = "**Fall leave**" }
  week(43) {
    active = true
    lecture("Reflection") {
      wednesday(afternoon)
      ability("principles for reflection in strongly typed object oriented languages", true)
      skill("runtime invokation of functions and class methods in Kotlin")

      overview = """
        We will look at DSL once more and then focus on reflection.
        """.trimIndent()

      read("`Member references and reflection` from Kotlin for Py", 2.0)
      read("`Other` -> `Reflection` from Kotlin reference", 2.0)

      // slideShow("resources/05-reflection-handouts.pdf")
      presentation("$slideRoot/05-reflection/05-reflection-handouts.pdf")
      externalLink("https://kotlinlang.org/docs/tutorials/kotlin-for-py/introduction.html") {
        title = "Kotlin for Py"
        }
      externalLink("https://kotlinlang.org/docs/reference/") {
        title = "Kotlin Reference"
        }
      externalLink("https://en.wikipedia.org/wiki/Reflection_(computer_programming)") {
        title = "Reflection (computer programming) - Wikipedia"
        }
      }
    }
  week(44) {
    title = "Coroutines"
    lecture("Build in coroutines") {
      ability("the difference between subroutines and coroutines and threding", true)
      skill("simple coroutine constructs in Kotlin and C# (`yeild`)")
      ability("the working of `suspend` functions")

      read("`Coroutine Basics` in Coroutines for ...", 3.0)

      externalLink("https://kotlinlang.org/docs/reference/coroutines-overview.html") {
        title = "Coroutines for asynchronous programming and more"
        }
      }
    lecture("Custom coroutines") {
      thursday(afternoon)
      skill("creation of simple custom coroutine apis in Kotlin")
      read("TBD", 3.0)
      work("exercise TBD", 4.0)
      presentation("$slideRoot/06-coroutines/06-coroutines-handouts.pdf")
      externalLink("https://proandroiddev.com/how-to-make-sense-of-kotlin-coroutines-b666c7151b93") {
        title = "How to make sense of Kotlin Coroutines"
        }
      }
    }
  week(45) {
    lecture("Network with TCP and UDP sockets") {
      note = "Project 1"
      knowledge("the TCP and UDP protocols, their strengths and weaknesses")
      skill("tcp and datagram sockets in Java and Kotlin")
      knowledge("socket programming in C#")
      assignment(
        "Mini project 1: Create a web server with coroutines and reflection",
        sourcePath = "$slideRoot/f1-assignment/mini-project-1.pdf",
        load = 15.0,
        credits = 30.0
        )
      presentation("$slideRoot/06-coroutines/06-coroutines-handouts.pdf")
      }
    lecture("Working with project 1") {
      thursday(afternoon)
      skill("a system from advanced Kotlin components and structures")

      write("report for mini project 1", 10.0)
      }
    }
  }
