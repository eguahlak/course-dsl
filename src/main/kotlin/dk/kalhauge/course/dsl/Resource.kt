package dk.kalhauge.course.dsl

class Resource(val lecture: Lecture, val sourcePath: String, val category: String, val toFront: Boolean) {
  var title = sourcePath.substringAfterLast("/")
  val link get() = sourcePath

  }

fun Lecture.resource(sourcePath: String, category: String, toFront: Boolean = false, build: Resource.() -> Unit = {} ): Resource {
  val resource = Resource(this, sourcePath, category, toFront)
  this.resources.add(resource)
  if (toFront) this.week.course.add(resource)
  resource.build()
  return resource
  }

fun Lecture.slides(sourcePath: String, build: Resource.() -> Unit = { }) =
    resource(sourcePath, "slides", true, build)
