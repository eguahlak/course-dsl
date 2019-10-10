package ap

import dk.kalhauge.course.dsl.*

fun Course.androidFlow() =    flow("Android") {
  text = """
      Kotlin has been selected by Google as the language for Android.
      We will have small detours to C and Arduinos (Node MCU’s)
      """.trimIndent()
  week(49) {
    lecture("Basics of native Android app")
    lecture("Connecting an app to the internet")
    }
  week(50) {
    lecture("Android recap") {
      note = "Mini project 3"
      assignment("Mini project 3: Control an IoT device from an Android app using UDP", load = 15.0, credits = 25.0)
      }
    lecture("Working with mini project 3")
    }
  }
