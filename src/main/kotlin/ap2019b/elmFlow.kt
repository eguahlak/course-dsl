package ap2019b

import dk.kalhauge.course.dsl.*
// import dk.kalhauge.org.course.dsl.*

fun Course.elmFlow() = flow("Elm") {
  text = """
      After living in the dark for several decades, functional programming is having a
      revival.
      The demand for parallelism, due to the change in CPU architecture with more and
      more cores, are challenging languages such as C# and Java.
      Functional programming handles parallel programming very elegantly and
      efficiently.
      The newest versions of object oriented languages introduce functional
      programming constructs to support parallelism.
      Elm is a functional language for browsers.
      """.trimIndent()
  skills = """
      Knowledge of functional programming will be an increasing demand in the future.
      """.trimIndent()
  week(46) {
    lecture("Basics") {
      ability("pros and cons of the functional paradigm", true)
      read("Core Language in Elm Official Guide", 2.0)
      work("exercises TBD", 2.0)

      presentation("$slideRoot/07-elm/07-elm-handouts.pdf")
      externalLink("https://guide.elm-lang.org") {
        title = "Elm Official Guide"
        }
      }
    lecture("Elm architecture") {
      knowledge("what a pure function is, and why it is important")
      ability("higher order functions", true)
      ability("the influence of sideeffects")

      overview = """
        ```elm
        import Html exposing (text)
        
        p30 = [(1, 2), (3, 4), (5, 6), (7, 8)]
        p1 = [(8, 9)]
        p0 = []
        l0 = [7, 9, 13]
        
        nthElement : Int -> List (Int, Int) -> (Int, Int)
        nthElement n l =
          case l of
            [] -> (0, 0)
            h::t -> case n of
              0 -> h
              _ -> nthElement (n - 1) t
              
        
        thirdProduct list =
          case list of
            [] -> 0
            _ :: _ :: (x3, y3) :: _ -> x3*y3
            _ -> 1
        
        asString (x, y) =
          (String.fromInt x)++","++(String.fromInt y)
        
        main =
          text (asString (nthElement 1 p30))
          -- text (String.fromInt (thirdProduct p30))
        ```
        """.trimIndent()

      read("The Elm Architecture in Elm Official Guide", 3.0)
      work("exercises TBD", 3.0)
      }
    }
  week(47) {
    lecture("Restful web services") {
      skill("the Elm communication api")

      read("Commands and Subscriptions -> HTTP in Elm Official Guide", 2.5)
      work("exercises TBD", 2.5)


      }
    lecture("Restful web services") {
      read("Commands and Subscriptions -> JSON in Elm Official Guide", 2.5)
      work("exercises TBD", 2.5)

      repository("https://github.com/datsoftlyngby/dat4sem2019fall-elm-code.git")
      externalLink("https://guide.elm-lang.org/effects/http.html")
      externalLink("https://guide.elm-lang.org/effects/json.html")
      }
    }
  week(48) {
    lecture("Elm recap") {
      note = "Project 2"
      skill("the Elm programming language")
      skill("a client-server application from using two new languages", true)

      externalLink("https://youtu.be/F9BunUsqDcs") {
        title = "Elm SPA tutorial part 1 (*OBS*: Elm 0.18)"
        }
      externalLink("https://youtu.be/U3pa-rQLSxA") {
        title = "Elm SPA tutorial part 2 (*OBS*: Elm 0.18)"
        }
      assignment(
        "Mini project 2: Elm frontend to the reflective server",
        sourcePath = "$slideRoot/f2-assignment/mini-project-2.pdf",
        load = 10.0,
        credits = 25.0
      )
      }
    lecture("Working with project 2") {
      write("report for mini project 2", 10.0)
      }
    }
  }

