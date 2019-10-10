package ap

import dk.kalhauge.course.dsl.*

fun Course.elmFlow() = flow("Elm") {
  text = """
      Elm is a functional language for browsers.
      It compiles to javascript.
      """.trimIndent()
  week(46) {
    lecture("Basics")
    lecture("Elm architecture")
    }
  week(47) {
    lecture("Restful webservices and websockets")
    lecture("Javascript ports")
    }
  week(48) {
    lecture("Elm recap") {
      note = "Mini project 2"
      assignment("Mini project 2", load = 15.0, credits = 25.0)
      }
    lecture("**Mini project 2**: API for connecting Kotlin backend with Elm")
    }
  }

