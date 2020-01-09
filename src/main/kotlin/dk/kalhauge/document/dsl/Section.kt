package dk.kalhauge.document.dsl

class Section(parent: Block.Parent, label: String? = null) : Block.Child(parent), Block.Parent/* , Anchor */ {
  override val children = mutableListOf<Block.Child>()
  var title: Text? = null
  var number: String = if (parent is Section) "${parent.number}.$index" else "$index"

  /*
  override val label = if (label == null) "sec:$number" else "sec:$label"

  override val link: Link
    get() = Link(document, title.let { if (it == null) label else it.nakedString() })
  */
  fun title(content: String? = null, build: Text.() -> Unit = { }) {
    title = text(content, build = build)
    }

  override fun print(indent: String) {
    println("${indent}Section: ${title?.nativeString()}")
    super.print(indent)
    }
  }

fun Block.Parent.section(title: String? = null, build: Section.() -> Unit = {}) =
    Section(this).also {
      it.title(title)
      it.build()
      add(it)
      }

