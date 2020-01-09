package ap2020a

import dk.kalhauge.org.course.dsl.*

fun Course.androidFlow() =    flow("Android") {
  text = """
      Kotlin has been selected by Google as the language for Android.
      We will have small detours to C and Arduinos (Node MCU’s)
      """.trimIndent()
  skills = """
      Mobile devices are getting more and more integrated in any business' it solutions.
      The overall architectures of the main systems iOS and Android does not differ significant,
      skills from one system can easily be transferred to another.
      """.trimIndent()
  /*
  week(49) {
    lecture("Basics of native Android app") {
      understands("the architecture of mobile devices in general", true)
      masters("simple android apps with multiple activities")
      read("TBD", 2.0)
      work("exercises TBD", 2.0)
      }
    lecture("Connecting an app to the internet") {
      understands("asynchronious programming of mobile devices", true)
      read("TBD", 2.0)
      work("exercises TBD", 2.0)
      }
    }
  week(50) {
    lecture("Android recap") {
      note = "Project 3"
      knows("performance issues and how to solve them, when working with small devices (IoT)")

      assignment("Mini project 3: Control an IoT device from an Android app using UDP", load = 10.0, credits = 25.0)
      }
    lecture("Working with project 3") {
      write("report for mini project 3", 10.0)
      }
    }
   */
  }
