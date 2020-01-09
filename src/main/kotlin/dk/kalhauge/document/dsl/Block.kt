package dk.kalhauge.document.dsl

interface Block {
  val level: Int
  fun print(indent: String = "")
  val document: Document

  interface Parent : Block {
    val children: MutableList<Block.Child>

    fun add(child: Child) {
      children.add(child)
      }

    override fun print(indent: String) {
      children.forEach { it.print("$indent  ") }
      }

    }

  abstract class Child(val parent: Parent) : Block {
    override val level = parent.level + 1
    val index = parent.children.size
    override val document: Document
      get() = parent.document
    }

  }
