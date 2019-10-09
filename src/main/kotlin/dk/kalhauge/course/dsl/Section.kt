package dk.kalhauge.course.dsl

class Section(val title: String, var text: String = "") {
  operator fun String.unaryPlus() {
    text += "\n\n"+this
    }
  }

fun Course.section(title: String, text: String = "", build: Section.() -> Unit = {}): Section {
  val section = Section(title)
  this.add(section)
  section.build()
  return section
  }

fun Lecture.section(title: String, text: String = "", build: Section.() -> Unit = {}): Section {
  val section = Section(title)
  this.add(section)
  section.build()
  return section
  }

