package ap2019b

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
  week(49) {
    lecture("Basics of native Android app") {
      understands("the architecture of mobile devices in general", true)
      masters("simple android apps with multiple activities")
      read("TBD", 2.0)
      work("Calculator App", 2.0)
      externalLink("https://developer.android.com/kotlin/learn")
      repository("https://github.com/datsoftlyngby/dat4sem2019spring-apps-vet.git")
      repository("https://github.com/eguahlak/lego-train-control.git")
      slideShow("$slideRoot/08-android/08-android-handouts.pdf")
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

      assignment(
          "Mini project 3: Android App",
          sourcePath = "$slideRoot/f3-assignment/mini-project-3.pdf",
          load = 10.0,
          credits = 25.0
          )
      }
    lecture("Working with project 3") {
      repository("https://github.com/datsoftlyngby/dat4sem2019fall-elm-spa")
      write("report for mini project 3", 10.0)
      }
    }
  }
