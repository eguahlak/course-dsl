package soft2020spring.alg

import dk.kalhauge.course.dsl.*
// import dk.kalhauge.org.course.dsl.*

fun Course.sortingFlow() = flow("Sorting") {
  text = """
      Here we will look at sorting data
      """.trimIndent()
  skills = """
      Some skills earned for real life
      """.trimIndent()
  week(6) {
    active = true
    lecture("Introduction") {
      objective = "To get an idea of the course content"
      presentation("$slideRoot/00-introduction/00-introduction-handouts.pdf")
      exercise("$slideRoot/00-introduction/exercise-example.pdf")
      }
    }
  /*
  week(40) {
    active = true
    lecture("Basics") {
      analysis("which programming language to choose for an application", true)
      understands("different implementations of properties")
      knows("the reason behind a restrictive code policy")
      understands("pros and cons of the structured programming paradigm", true)

      read("`Basics` chapter in Kotlin reference", 3.0)
      work("Install IntelliJ IDE", 2.0)
      work("expected selfstudy", 1.0)

      //slideShow("resources/01-basic-kotlin-handouts.pdf")
      slideShow("$slideRoot/01-basic-kotlin/01-basic-kotlin-handouts.pdf")
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
      understands("the difference between relations and references")
      masters("creation of classes and objects in Kotlin")
      understands("custom properties and delegated properties")
      understands("pros and cons of the object oriented programming language paradigm")

      read("`Classes and Objects` chapter in Kotlin reference", 2.0)
      work("work on exercise", 4.0)
      work("expected selfstudy", 1.0)
      }
    }
  week(41) {
    active = true

    lecture("Lambdas, collections, and streams") {
      understands("functions as first class citizens", true)
      knows("the difference between functions, methods, and procedures")
      knows("the properties of collections and streams, and their differences")

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
      understands("Extension functions and extension lambdas")
      masters("Kotlin programming language", true)
      masters("building a DSL from the buttom up using extension functions and lambdas")

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
      understands("principles for reflection in strongly typed object oriented languages", true)
      masters("runtime invokation of functions and class methods in Kotlin")

      overview = """
        We will look at DSL once more and then focus on reflection.
        """.trimIndent()

      read("`Member references and reflection` from Kotlin for Py", 2.0)
      read("`Other` -> `Reflection` from Kotlin reference", 2.0)

      // slideShow("resources/05-reflection-handouts.pdf")
      slideShow("$slideRoot/05-reflection/05-reflection-handouts.pdf")
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
      understands("the difference between subroutines and coroutines and threding", true)
      masters("simple coroutine constructs in Kotlin and C# (`yeild`)")
      understands("the working of `suspend` functions")

      read("`Coroutine Basics` in Coroutines for ...", 3.0)

      externalLink("https://kotlinlang.org/docs/reference/coroutines-overview.html") {
        title = "Coroutines for asynchronous programming and more"
        }
      }
    lecture("Custom coroutines") {
      thursday(afternoon)
      masters("creation of simple custom coroutine apis in Kotlin")
      read("TBD", 3.0)
      work("exercise TBD", 4.0)
      slideShow("$slideRoot/06-coroutines/06-coroutines-handouts.pdf")
      externalLink("https://proandroiddev.com/how-to-make-sense-of-kotlin-coroutines-b666c7151b93") {
        title = "How to make sense of Kotlin Coroutines"
        }
      }
    }
  week(45) {
    lecture("Network with TCP and UDP sockets") {
      note = "Project 1"
      knows("the TCP and UDP protocols, their strengths and weaknesses")
      masters("tcp and datagram sockets in Java and Kotlin")
      knows("socket programming in C#")
      assignment(
        "Mini project 1: Create a web server with coroutines and reflection",
        sourcePath = "$slideRoot/f1-assignment/mini-project-1.pdf",
        load = 15.0,
        credits = 30.0
        )
      slideShow("$slideRoot/06-coroutines/06-coroutines-handouts.pdf")
      }
    lecture("Working with project 1") {
      thursday(afternoon)
      synthesis("a system from advanced Kotlin components and structures")

      write("report for mini project 1", 10.0)
      }
    }
   */
  }
