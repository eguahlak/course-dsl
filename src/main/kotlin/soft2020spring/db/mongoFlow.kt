package soft2020spring.db

import dk.kalhauge.course.dsl.*

fun Course.mongoFlow() = flow("Mongo DB")
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
        {}
    }

    week(13)
    {
        active = true
        lecture("Processing data with Mongo DB")
        {}
    }

    week(14)
    {
        active = true
        lecture("Selected Implementation of Mongo DB")
        {}
    }

    week(15)
    {
        active = true
        lecture("*** Easter Holiday ***")
        {}
    }
}