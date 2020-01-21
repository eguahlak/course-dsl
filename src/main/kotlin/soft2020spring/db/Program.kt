package soft2020spring.db

import dk.kalhauge.course.dsl.*
import dk.kalhauge.course.printers.FileContext
import dk.kalhauge.course.printers.GitHubPagesVisitor
import dk.kalhauge.util.anchorize

val localRoot = "/Users/tdi/Documents/Teaching/DB/2020/"
val gitRoot = "http://github.com/datsoftlyngby/soft2020spring-DB/"

fun main() {
  val course = course("Databases for Developers", spring(2020), root = "DB/")
  {
      thursday(morning)
      //wednesday(afternoon)
      overview = """
        This cource ...
        """.trimIndent()

      plan = """
      The course content is divided into two main streams: SQL Databases and NoSQL Databases. ...
      """.trimIndent()

      sqlFlow()
      flow("SQL")
      {
        week(6)
        {
          lecture("SQL Recap")
        }
      }

      hbaseFlow()
      flow("HBase")
      {
        week(10)
        {
          lecture("HBASE")
        }
      }

      mongoFlow()
      flow("Mongo DB")
      {
        week(12)
        {
          lecture("MongoDB")
        }
      }

      neoFlow()
      flow("Neo4j")
      {
          week(16)
          {
              lecture("Neo4J")
          }
      }

      redisFlow()
      flow("Redis")
      {
          week(19)
          {
              lecture("Redis")
          }
      }
      // attendance(20.0)

      exam = """
      Oral exam, based on a group exam project.
      A student must have collected a minimum of 80 [credits](#${"Assignments and Credits".anchorize()}) during the semester to attend the exam.
      """.trimIndent()
  }

  GitHubPagesVisitor(
    FileContext("/Users/tdi/Documents/GitHub/soft2020spring/docs"))
    .visit(course)
  // GitHubPagesVisitor(ConsoleContext()).visit(course)
  }