package soft2020spring.ai

import dk.kalhauge.course.dsl.*
// import dk.kalhauge.org.course.dsl.*

fun Course.aiFlow() = flow("Artificial Intelligence")
{
  text = """
      We will look at basis and the advanced topics of ...
      """.trimIndent()
  skills = """
      Learning a new language is an important skill in an ever changing world.
      """.trimIndent()

  week(6)
  {
      active = true
      lecture("Introduction to AI")
      {
          note = ""
          objective = "To get an idea of the course content ..."
          knowledge("which programming language to choose for an application", true)
          ability("different implementations of properties", true)
          skill("the reason behind a restrictive code policy", true)
          overview = """
            Agenda here
          """.trimIndent()

          // Resources here, in this order
          presentation("$localRoot/Presentations/ai1.pdf")
          exercise("$localRoot/Exercises/Ex1-1.pdf")
          exercise("$localRoot/Exercises/Ex1-2.pdf")
          exercise("$localRoot/Exercises/Ex1-3.pdf")
          repository("$gitRoot")
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

          // Activities
          attendance(credits = 1.0)
          read("Lecture Notes", 1.00)
          work("Exercise 1", 0.50)
          work("Exercise 2", 0.50)
          work("Exercise 3", 0.50)
          read("Reading Task", 0.30)
          write("Your answers on the reading task", 0.50)
          assignment(
              "Homework Assignment 1: Create ...",
              sourcePath = "$localRoot/Assignments/HW1.pdf",
              load = 5.0,
              credits = 0.0
          )
          assignment(
              "Mini project 1: Create ...",
              sourcePath = "$localRoot/Assignments/MP1.pdf",
              load = 15.0,
              credits = 30.0
          )
          work("selfstudy", 4.0)

      }
  }

   week(7)
   {
        active = true
        lecture("AI2")
        {
            note = ""
            objective = "To get an idea of the course content"
            knowledge("which programming language to choose for an application", true)
            ability("different implementations of properties", true)
            skill("the reason behind a restrictive code policy", true)
            overview = """
        Agenda here
        """.trimIndent()
            presentation("$localRoot/Presentations/ai1.pdf")
            exercise("$localRoot/Exercises/Ex1-1.pdf")
            exercise("$localRoot/Exercises/Ex1-2.pdf")
            exercise("$localRoot/Exercises/Ex1-3.pdf")
            assignment(
                "Homework 2: Create ...",
                sourcePath = "$localRoot/Assignments/HW1.pdf",
                load = 5.0,
                credits = 0.0
            )
            assignment(
                "Mini project 1: Create ...",
                sourcePath = "$localRoot/Assignments/MP1.pdf",
                load = 15.0,
                credits = 30.0
            )
            attendance(credits = 1.0)
            work("Exercise 1", 0.50)
            work("Exercise 2", 0.50)
            work("Exercise 3", 0.50)
            read("Homework 2", 0.30)
            write("Your answers on Homework 2", 0.50)
            work("Assignment 1", 2.0)
            work("selfstudy", 4.0)

            repository("$gitRoot")
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

    week(8)
    {
        active = true
        lecture("AI3")
        {
          note = ""
          objective = "To get an idea of the course content"
          knowledge("which programming language to choose for an application", true)
          ability("different implementations of properties", true)
          skill("the reason behind a restrictive code policy", true)
          overview = """
        Agenda here
        """.trimIndent()
          presentation("$localRoot/Presentations/ai1.pdf")
          exercise("$localRoot/Exercises/Ex1-1.pdf")
          exercise("$localRoot/Exercises/Ex1-2.pdf")
          exercise("$localRoot/Exercises/Ex1-3.pdf")
          assignment(
            "Homework 3: Create ...",
            sourcePath = "$localRoot/Assignments/HW1.pdf",
            load = 5.0,
            credits = 0.0
          )
          assignment(
            "Mini project 1: Create ...",
            sourcePath = "$localRoot/Assignments/MP1.pdf",
            load = 15.0,
            credits = 30.0
          )
          attendance(credits = 1.0)
          work("Exercise 1", 0.50)
          work("Exercise 2", 0.50)
          work("Exercise 3", 0.50)
          read("Homework 3", 0.30)
          write("Your answers on Homework 3", 0.50)
          work("Assignment 1", 2.0)
          work("selfstudy", 4.0)

          repository("$gitRoot")
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
}

