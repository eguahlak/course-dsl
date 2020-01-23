package soft2020spring.db

import dk.kalhauge.course.dsl.*

fun Course.mongoFlow() = flow("Document-Based NoSQL: Mongo DB")
{
    text = """
      Mongo DB is the most popular representative of document  -oriented NoSQL databases. 
      It provides good performance and easy data access, which make it appropriate for storing and processing data, which lacks a structured schema.
      """.trimIndent()
    skills = """
      Familiarity with this flexible database brings numerous options for its implementation in various web development projects.
      """.trimIndent()

    week(12)
    {
        active = true
        lecture("Introduction to Mongo DB")
        {
            note = "A"
        }
    }

    week(13)
    {
        active = true
        lecture("Processing data with Mongo DB")
        {
            note = "A"
        }
    }

    week(14)
    {
        active = true
        lecture("Selected Implementation of Mongo DB")
        {
            note = "A"
        }
    }

    week(15)
    {
        active = true
        lecture("*** Easter Holiday ***")
        {}
    }
}