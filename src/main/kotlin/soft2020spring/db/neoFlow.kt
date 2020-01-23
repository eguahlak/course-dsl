package soft2020spring.db

import dk.kalhauge.course.dsl.*

fun Course.neoFlow() = flow("Graph-Oriented NoSQL Database: Neo4J")
{
    text = """
      Neo4J is known as a leader in the family of graph-oriented NoSQL databases. 
      It stores not only data items, but also links and connections between them in a graph structures, similar to the structure of the social networks.
      """.trimIndent()
    skills = """
      Familiarity with this prospective database and its language Cypher enables you to create large scale graph data applications. 
      """.trimIndent()

    week(16)
    {
        active = true
        lecture("Introduction to Graph Data and Neo4J")
        {
            note = "D"
        }
    }

    week(17)
    {
        active = true
        lecture("Introduction to Cypher")
        {
            note = "D"
        }
    }

    week(18  )
    {
        active = true
        lecture("Selected Implementatipns of Graph DB and Neo4J")
        {
            note = "D"
        }
    }
}