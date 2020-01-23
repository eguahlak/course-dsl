package soft2020spring.db

import dk.kalhauge.course.dsl.*

fun Course.redisFlow() = flow("Key-Value NoSQL Data Store: Redis")
{
    text = """
      Redis is a key-value store, the forth type of NoSQL databases. 
      It is one of the fastest databases, which can store various complex data types, and still very simple to use.
      """.trimIndent()
    skills = """
      Familiarity with this modern database and its command set will open new perspectives in building multidatabase solutions. 
      """.trimIndent()

    week(19)
    {
        active = true
        lecture("Introduction and Implementations of Redis")
        {
            note = "A"
        }
    }

    week(20)
    {
        active = true
        lecture("NoSql Multidatabase Project Presentation")
        {
            note = "AD"
        }
    }

    week(21)
    {
        active = true
        lecture("Exam Project")
        {
            note = "AD"
        }
    }

    week(22)
    {
        active = true
        lecture("Exam Project")
        {
            note = "AD"
        }
    }
}