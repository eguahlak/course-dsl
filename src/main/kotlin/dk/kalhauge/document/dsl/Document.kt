package dk.kalhauge.document.dsl


class Document : Block.Parent {
  override val level = 0
  override val children = mutableListOf<Block.Child>()
  override val document = this
  //override val links = mutableMapOf<String, Link>()
  }

fun document(build: Document.() -> Unit) = Document().also(build)

