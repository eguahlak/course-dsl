package dk.kalhauge.document.dsl

import dk.kalhauge.document.dsl.HorisontalAlignment.*
import dk.kalhauge.document.dsl.VerticalAlignment.*
import dk.kalhauge.document.dsl.text as ttext

interface Figure {
  val capture: Text?
  }

enum class HorisontalAlignment { LEFT, CENTER, RIGHT, JUSTIFY } // TODO Find name for XYZ

enum class VerticalAlignment { TOP, MIDDLE, BOTTOM }

class Table(parent: Block.Parent, override val capture: Text? = null) : Block.Child(parent), Figure {
  val columns = mutableListOf<Column>()
  val rows = mutableListOf<Row>()

  fun column(title: String? = null, alignment: HorisontalAlignment = LEFT, build: Column.() -> Unit = { }) =
    Column(this, alignment).also { c ->
      title?.let { c.title(title) }
      c.build()
      }

  fun left(title: String? = null, build: Column.() -> Unit = {}) =
    column(title, LEFT, build)

  fun center(title: String? = null, build: Column.() -> Unit = {}) =
    column(title, CENTER, build)

  fun right(title: String? = null, build: Column.() -> Unit = {}) =
    column(title, RIGHT, build)

  fun justify(title: String? = null, build: Column.() -> Unit = {}) =
    column(title, JUSTIFY, build)

  fun row(alignment: VerticalAlignment = TOP, build: Row.() -> Unit = {}) =
    Row(this, alignment).also { it.build() }

  override fun print(indent: String) { TODO("implement function print") }

  class Column(val table: Table, val alignment: HorisontalAlignment) {
    var index = table.columns.size
    var title: Text? = null

    fun title(content: String? = null, build: Text.() -> Unit = { }) {
      title = ttext(content, build = build)
      }

    init {
      table.columns += this
      }

    }

  class Row(val table: Table, val alignment: VerticalAlignment) {
    val index = table.rows.size
    val cells = mutableListOf<Cell>()

    init {
      table.rows += this
      }

    fun cell(value: String? = null, build: Cell.() -> Unit = { }) =
      Cell(this).also { c ->
        value?.let { c.text(it) }
        c.build()
        }
    }

  class Cell(val row: Row) {
    val index = row.cells.size
    val column = row.table.columns[index]
    var value: Inline? = null

    fun text(content: String? = null, build: Text.() -> Unit = { }) {
      value = ttext(content, build = build)
      }

    init {
      row.cells += this
      }
    }

  }

fun Block.Parent.table(build: Table.() -> Unit = { }) =
  Table(this).also {
    it.build()
    add(it)
    }