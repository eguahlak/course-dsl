package ap

import dk.kalhauge.course.dsl.*

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
      slideShow("resources/00-kotlin.pdf")
      }
    }
  week(40) {
    active = true
    lecture("Basics") {
      understands("different implementations of properties")
      knows("the reason behind a restrictive code policy")

      read("`Basics` chapter in Kotlin reference", 3.0)
      work("Install IntelliJ IDE", 2.0)
      work("expected selfstudy", 1.0)

      slideShow("resources/01-basic-kotlin-handouts.pdf")
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

      read("`Classes and Objects` chapter in Kotlin reference", 2.0)
      work("work on exercise", 4.0)
      work("expected selfstudy", 1.0)
      }
    }
  week(41) {
    active = true
    lecture("Lambdas, collections, and streams") {
      understands("functions as first class citizens")
      knows("the difference between functions, methods, and procedures")
      knows("the properties of collections and streams, and their differences")

      read("`Functions and Lambdas` and `Collection` chapters from Kotlin reference", 3.5)
      work("expected selfstudy", 2.0)
      }
    lecture("Extension functions and DSL") {
      wednesday("13:00" to "16:00")
      note = "Internship fair"
      understands("Extension functions and extension lambdas")
      masters("building a DSL from the buttom up using extension functions and lambdas")

      read("`Functional Programming` from Kotlin for Py", 3.0)
      work("Chorus (or similar) DSL exercise", 5.0)

      externalLink("https://kotlinlang.org/docs/tutorials/kotlin-for-py/introduction.html") {
        toFront = true
        title = "Kotlin for Py"
        }
      }
    }
  week(42) { title = "**Fall leave**" }
  week(43) {
    active = true
    lecture("Reflection") {
      understands("principles for reflection in strongly typed object oriented languages")
      masters("runtime invokation of functions and class methods in Kotlin")

      read("`Member references and reflection` from Kotlin for Py", 2.0)
      read("`Other` -> `Reflection` from Kotlin reference", 2.0)

      externalLink("https://kotlinlang.org/docs/tutorials/kotlin-for-py/introduction.html") {
        title = "Kotlin for Py"
        }
      externalLink("https://kotlinlang.org/docs/reference/") {
        title = "Kotlin Reference"
        }
      }
    lecture("Network with TCP and UDP sockets")
    }
  week(44) {
    title = "Coroutines"
    lecture("Build in coroutines")
    lecture("Custom coroutines")
    }
  week(45) {
    lecture("**Mini project 1**: Create a web server with coroutines and reflection.") {
      wednesday(afternoon)
      note = "Mini project 1"
      assignment("Mini project 1", load = 20.0, credits = 30.0)
      }
    }
  }
