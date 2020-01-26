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
            Overview of your knowledge and experience in working with RDB:
            * RDB Modelling and Design
            * Normalisation and De-normalization
            * Relational Algebra
            * SQL
            * ORM
          """.trimIndent()

            // Resources here, in this order
            presentation("${soft2020spring.db.localRoot}/Presentations/Test.pdf")
            {
                title = "Overview of Relational Database Design and Development"
            }
            exercise("${soft2020spring.db.localRoot}/Exercises/Test.pdf")
            exercise("${soft2020spring.db.localRoot}/Exercises/l01.pdf")
            exercise("${soft2020spring.db.localRoot}/Exercises/Test.pdf")

            repository("${soft2020spring.db.gitioRoot}")
            repository("${soft2020spring.db.gitRoot}")

            externalLink("https://www.postgresql.org/")
            {
                toFront = true
                title = "PostgreSQL Database"
            }
            externalLink("https://pragprog.com/book/pwrdata/seven-databases-in-seven-weeks-second-edition")
            {
                toFront = true
                title = "Seven Databases in Seven Weeks"
            }

            // Activities
            attendance(credits = 1.0)
            read("Lecture Notes", 1.00)
            /*
            work("Exercise 1", 0.50)
            work("Exercise 2", 0.50)
            work("Exercise 3", 0.50)
            */
            read("The introduction, Day 1, and Day 2 from Chapter 2: PostgreSQL", 2.00)
            write("How does PostgreSQL differ from the DBMS, you have used in your earlier studies?", 0.50)

            assignment(
                "Homework Assignment 1: ...",
                sourcePath = "${soft2020spring.db.localRoot}/Assignments/Test.pdf",
                load = 3.0,
                credits = 3.0
            )

            assignment(
                "Mini Project 1",
                sourcePath = "${soft2020spring.db.localRoot}/Assignments/Test.pdf",
                load = 5.0,
                credits = 0.0
            )

            assignment(
                "Draft of the Exam Project",
                sourcePath = "${soft2020spring.db.localRoot}/Assignments/Test.pdf",
                load = 1.0,
                credits = 0.0
            )
            work("Self-Study", 4.0)
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
            * View
          """.trimIndent()

            // Resources here, in this order
            presentation("${soft2020spring.db.localRoot}/Presentations/Test.pdf")
            {
                title = "Overview of Relational Database Design and Development"
            }
            exercise("${soft2020spring.db.localRoot}/Exercises/Test.pdf")
            exercise("${soft2020spring.db.localRoot}/Exercises/l01.pdf")
            exercise("${soft2020spring.db.localRoot}/Exercises/Test.pdf")

            repository("${soft2020spring.db.gitioRoot}")
            repository("${soft2020spring.db.gitRoot}")

            externalLink("https://www.postgresql.org/")
            {
                toFront = true
                title = "PostgreSQL Database"
            }
            externalLink("https://pragprog.com/book/pwrdata/seven-databases-in-seven-weeks-second-edition")
            {
                toFront = true
                title = "Seven Databases in Seven Weeks"
            }

            // Activities
            attendance(credits = 1.0)
            read("Lecture Notes", 1.00)

            read("The introduction, Day 2, and Day 3 from Chapter 2: PostgreSQL", 2.00)
            write("Question comes here ...", 0.50)

            assignment(
                "Homework Assignment 2: ...",
                sourcePath = "${soft2020spring.db.localRoot}/Assignments/Test.pdf",
                load = 3.0,
                credits = 3.0
            )

            assignment(
                "Mini Project 1",
                sourcePath = "${soft2020spring.db.localRoot}/Assignments/Test.pdf",
                load = 5.0,
                credits = 0.0
            )

            assignment(
                "Draft of the Exam Project",
                sourcePath = "${soft2020spring.db.localRoot}/Assignments/Test.pdf",
                load = 2.0,
                credits = 0.0
            )
            work("Self-Study", 4.0)
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

            // Resources here, in this order
            presentation("${soft2020spring.db.localRoot}/Presentations/Test.pdf")
            {
                title = "Overview of Relational Database Design and Development"
            }
            exercise("${soft2020spring.db.localRoot}/Exercises/Test.pdf")
            exercise("${soft2020spring.db.localRoot}/Exercises/l01.pdf")
            exercise("${soft2020spring.db.localRoot}/Exercises/Test.pdf")

            repository("${soft2020spring.db.gitioRoot}")
            repository("${soft2020spring.db.gitRoot}")

            externalLink("https://www.postgresql.org/")
            {
                toFront = true
                title = "PostgreSQL Database"
            }
            externalLink("https://pragprog.com/book/pwrdata/seven-databases-in-seven-weeks-second-edition")
            {
                toFront = true
                title = "Seven Databases in Seven Weeks"
            }

            // Activities
            attendance(credits = 1.0)
            read("Lecture Notes", 1.00)

            read("Day 3 from Chapter 2: PostgreSQL", 2.00)
            write("Question comes here ...", 0.50)

            assignment(
                "Homework Assignment 3: ...",
                sourcePath = "${soft2020spring.db.localRoot}/Assignments/Test.pdf",
                load = 3.0,
                credits = 3.0
            )

            assignment(
                "Mini Project 1",
                sourcePath = "${soft2020spring.db.localRoot}/Assignments/Test.pdf",
                load = 5.0,
                credits = 0.0
            )

            assignment(
                "Draft of the Exam Project",
                sourcePath = "${soft2020spring.db.localRoot}/Assignments/Test.pdf",
                load = 2.0,
                credits = 0.0
            )

            work("Self-Study", 4.0)
        }
    }

    week(9)
    {
        active = true
        lecture("Groups Present Their RDB Mini Project in Class")
        {
            note = "AD"

            assignment(
                "Mini Project 1",
                sourcePath = "${soft2020spring.db.localRoot}/Assignments/Test.pdf",
                load = 4.0,
                credits = 30.0
            )
        }
    }
}