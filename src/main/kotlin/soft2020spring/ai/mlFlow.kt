package soft2020spring.ai

import dk.kalhauge.course.dsl.*
// import dk.kalhauge.org.course.dsl.*

fun Course.mlFlow() = flow("Machine Learning")
{
  text = """
      We will look at basis and the advanced topics of ...
      """.trimIndent()
  skills = """
      Learning a new language is an important skill in an ever changing world.
      """.trimIndent()

  week(9)
  {
    active = true
    lecture("ML1")
    {
      note = ""
      objective = "To get an idea of the course content"
      knowledge("which programming language to choose for an application", true)
      ability("different implementations of properties", true)
      skill("the reason behind a restrictive code policy", true)
      overview = """
        Agenda here
        """.trimIndent()
      presentation("$localRoot/Presentations/ml1.pdf")
      exercise("$localRoot/Exercises/Ex1-1.pdf")
      exercise("$localRoot/Exercises/Ex1-2.pdf")
      exercise("$localRoot/Exercises/Ex1-3.pdf")
      assignment(
        "Homework 1: Create ...",
        sourcePath = "$localRoot/Assignments/HW1.pdf",
        load = 5.0,
        credits = 0.0
      )
      assignment(
        "Mini project 2: Create ...",
        sourcePath = "$localRoot/Assignments/MP2.pdf",
        load = 15.0,
        credits = 30.0
      )
      attendance(credits = 1.0)
      work("Exercise 1", 0.50)
      work("Exercise 2", 0.50)
      work("Exercise 3", 0.50)
      read("Homework 1", 0.30)
      write("Your answers on Homework 1", 0.50)
      work("Assignment 2", 2.0)
      work("selfstudy", 4.0)

      repository("$gitRoot/")
      externalLink("http://cphbusiness.dk")
      {
        toFront = true
        title = "Test Link"
      }
      externalLink("http://cphbusiness.dk")
      {
        toFront = true
        title = "Test Link"
      }

    }
  }

  week(15)
  { title = "**Easter Break**"
    active = true
  }
}