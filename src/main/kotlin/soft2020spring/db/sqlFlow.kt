package soft2020spring.db

import dk.kalhauge.course.dsl.*

fun Course.sqlFlow() = flow("SQL Databases")
{
    text = """
      This is to extend your knowledge on SQL Databases with advanced topics, focusing on performance and optimization. 
      You will be working with programming units, transaction management, and execution plans, to get prepared for data-centered development solutions and jobs.
      """.trimIndent()
    skills = """
      Profficiency in database design and development is an advantage in an ever changing digital world.
      """.trimIndent()

    week(6)
    {
        active = true
        lecture("Relational Databases Recap")
        {}
    }

    week(7)
    {
        active = true
        lecture("Programming RDB")
        {}
    }

    week(8)
    {
        active = true
        lecture("Managing Transactions and Locks")
        {}
    }

    week(9)
    {
        active = true
        lecture("Query Analysis and Optimization")
        {}
    }

    week(10)
    {
        active = true
        lecture("RDB Project Presentation")
        {}
    }
}