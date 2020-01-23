package soft2020spring.db

import dk.kalhauge.course.dsl.*

fun Course.hbaseFlow() = flow("HBase")
{
    text = """
      HBase is the most famous representative of column-oriented NoSQL databases. 
      It provides high consistency and scallability, which make it the obvious choice for storing and processing big data.
      """.trimIndent()
    skills = """
      Familiarity with this powerful database and its family of technologies, the Hadoop ecosystem, 
extends your understanding and qualification in development of systems as large as Facebook Messages, Tweeter search, 
Airbnb, and many others, working with big data.
      """.trimIndent()

    week(10)
    {
        active = true
        lecture("Introduction to Big Data and Hadoop")
        {}
    }

    week(11)
    {
        active = true
        lecture("Processing Big Data by Use of HBase")
        {}
    }
}