package dk.kalhauge.course.dsl

interface Target {
  val localPath: String
  val globalPath: String
  }

class Link(var text: String, val target: Target)

