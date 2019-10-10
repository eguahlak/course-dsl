package dk.kalhauge.course.dsl

abstract class Resource(val lecture: Lecture, var toFront: Boolean) : Link {
  abstract val category: String
  override var active = true
  }

class SlideShowResource(lecture: Lecture, toFront: Boolean, val sourcePath: String) : Resource(lecture, toFront) {
  override val category = "slide-show"
  override var title = sourcePath.substringAfterLast("/")
  override val link = sourcePath
  }

class RepositoryResource(lecture: Lecture, toFront: Boolean, val sourcePath: String) : Resource(lecture, toFront) {
  override val category = "repository"
  override var title = sourcePath.substringAfter(".com/")
  override val link = sourcePath
  }

class ExternalLinkResource(lecture: Lecture, toFront: Boolean, val sourcePath: String) : Resource(lecture, toFront) {
  override val category = "external-link"
  override var title = "`$sourcePath`"
  override val link = sourcePath
  }

fun Lecture.slideShow(sourcePath: String, build: SlideShowResource.() -> Unit = { } ): SlideShowResource {
  val slideShow = SlideShowResource(this, true, sourcePath)
  slideShow.build()
  add(slideShow)
  return slideShow
  }

fun Lecture.repository(sourcePath: String, build: RepositoryResource.() -> Unit = { } ): RepositoryResource {
  val repository = RepositoryResource(this, true, sourcePath)
  repository.build()
  add(repository)
  return repository
  }

fun Lecture.externalLink(sourcePath: String, build: ExternalLinkResource.() -> Unit = { }): ExternalLinkResource {
  val externalLink = ExternalLinkResource(this, false, sourcePath)
  externalLink.build()
  add(externalLink)
  return externalLink
  }



