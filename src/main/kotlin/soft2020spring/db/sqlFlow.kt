package soft2020spring.db

import dk.kalhauge.course.dsl.*

fun Course.sqlFlow() = flow("SQL Databases")
{
    text = """
      This is to extend your knowledge on SQL Databases with advanced topics, focusing on performance and optimization. 
      You will be working with programming units, transaction management, and execution plans, to get prepared for data-centered development solutions and jobs.
      """.trimIndent()
    skills = """
      Proficiency in database design and development is an advantage in an ever changing digital world.
      """.trimIndent()

    week(6)
    {
        active = true
        lecture("Relational Databases Recap")
        {
            note = "A"
            overview = """
            Overview of knowledge and experience in working with RDB:
            * RDB Modelling and Design
            * Normalisation and De-normalization
            * Relational Algebra
            * SQL
            * ORM
          """.trimIndent()
        }
    }

    week(7)
    {
        active = true
        lecture("Programming RDB")
        {
            note = "A"
            overview = """
            RDB Development and Implementation, Program Objects:
            * Advanced SQL
            * Integration Constrains
            * Triggers
            * Stored Procedures
            * User-Defined Functions
          """.trimIndent()
        }
    }

    week(8)
    {
        active = true
        lecture("RDB Management and Optimization")
        {
            note = "D"
            overview = """
            RDB Management and Optimization:
            * Managing Transactions and Locks
            * Concurrency Control
            * Query Analysis and Optimization
            * Execution Plans
            * Access Management
          """.trimIndent()
        }
    }

    week(9)
    {
        active = true
        lecture("RDB Project Presentation")
        {
            note = "AD"
        }
    }
}