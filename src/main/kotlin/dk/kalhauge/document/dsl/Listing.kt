package dk.kalhauge.document.dsl


class Listing(parent: Block.Parent, val type: Type) : Block.Child(parent), Block.Parent {
  enum class Type { BULLETED, ARABIC, ROMAN, ALPHABETIC }
  val depth: Int
    get() = if (parent is Listing) parent.depth + 1 else 0
  override val children = mutableListOf<Block.Child>()
  override fun print(indent: String) {
    println("${indent}Listing")
    super.print(indent)
    }
  }

class Item(parent: Listing) : Block.Child(parent) {
  val parts = mutableListOf<Inline>()

  fun add(part: Inline) { parts += part }

  fun text(
      content: String? = null,
      format: Text.Format = Text.Format.NORMAL,
      build: Text.() -> Unit = { }) =
    Text(format).also { t ->
      content?.let { c -> t.readContent(c.iterator()) }
      t.build()
      this.add(t)
      }

  override fun print(indent: String) {
    println("${indent}Item")
    parts.forEach { println("$indent  ${it.nativeString()}") }
    }
  }


fun Block.Parent.list(
    type: Listing.Type = Listing.Type.BULLETED,
    build: Listing.() -> Unit = {}
    ) = Listing(this, type).also {
  it.build()
  this.add(it)
  }

fun Listing.item(content: String? = null, build: Item.() -> Unit = {}) =
  Item(this).also { p ->
    content?.let { c -> p.add(text(c)) }
    p.build()
    add(p)
  }