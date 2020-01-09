package dk.kalhauge.document.dsl

class Paragraph(parent: Block.Parent) : Block.Child(parent) {
  val parts = mutableListOf<Inline>()

  fun add(part: Inline) { parts += part }

  override fun print(indent: String) {
    println("${indent}Paragraph")
    parts.forEach { println("$indent  ${it.nativeString()}") }
    }

  fun text(
      content: String? = null,
      format: Text.Format = Text.Format.NORMAL,
      build: Text.() -> Unit = { }) =
    Text(format).also { t ->
      content?.let { c -> t.readContent(c.iterator()) }
      t.build()
      this.add(t)
      }

  }

fun Section.paragraph(content: String? = null, build: Paragraph.() -> Unit = {}) =
  Paragraph(this).also { p ->
    content?.let { c -> p.add(text(c)) }
    p.build()
    add(p)
    }

