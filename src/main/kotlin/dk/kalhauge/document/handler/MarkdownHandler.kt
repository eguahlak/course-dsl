package dk.kalhauge.document.handler

import dk.kalhauge.document.dsl.*
import dk.kalhauge.document.dsl.Text.Format.*
import dk.kalhauge.util.of

class MarkdownHandler(val context: Host) {
  fun handle(node: Document) {
    node.children.forEach { handle(it) }
    }

  fun handle(node: Block.Child) {
    with (context) {
      when (node) {
        is Section -> {
          printLine(node.level of "#", handle(node.title))
          node.children.forEach { handle(it) }
          }
        is Paragraph -> {
          node.parts.forEach { printLine(handle(it)) }
          }
        is Listing -> {
          when (node.parent) {
            is Listing -> {
              indent += 2
              node.children.forEach { handle(it) }
              indent -= 2
              }
            else -> {
              node.children.forEach { handle(it) }
              printLine()
              }
            }
          }
        is Item -> {
          node.parts.forEachIndexed { index, inline ->
            if (index == 0)
              printLine((node.parent as Listing).type mark node.index, handle(inline), 0)
            else printLine("  ", handle(inline), 0)
            }
          }
        is Table -> {
          printLine(node.columns.map { handle(it.title) }.joinToString(" | ", "| ", " |"), 0)
          printLine(node.columns.map { handle(it.alignment) }.joinToString(" | ", "| ", " |"), 0)
          node.rows.forEach { row ->
            printLine(row.cells.map { handle(it.value) }.joinToString(" | ", "| ", " |"), 0)
            }
          printLine()
          }
        is Code -> {
          printLine("```${node.language}", 0)
          printLine(node.text, 0)
          printLine("```")
          }
        else -> printLine("Unknown Block Child ${node}")
        }
      }
    }

  infix fun Listing.Type.mark(index: Int) =
    when (this) {
      Listing.Type.BULLETED -> " *"
      Listing.Type.ARABIC -> " ${index + 1}."
      Listing.Type.ALPHABETIC -> " a."
      Listing.Type.ROMAN -> " i."
      }

  infix fun String.with(format: Text.Format) =
    when (format) {
      NORMAL -> this
      BOLD -> "**$this**"
      ITALIC -> "_${this}_"
      UNDERLINE -> "<u>$this</u>"
      STRIKE -> "~$this~"
      CODE -> "`$this`"
      }

  fun handle(inline: Inline?, indent: String = "", margin: Int = 80): String =
    indent+when (inline) {
      null -> ""
      is Content -> inline.value
      is Text ->  if (inline.isEmpty()) """\${inline.format.delimiter}"""
                  else inline.parts.joinToString("") { handle(it) } with inline.format
      else -> "<UNKNOWN: $this>"
      }

  fun handle(alignment: HorisontalAlignment) =
    when (alignment) {
      HorisontalAlignment.LEFT ->    ":----"
      HorisontalAlignment.CENTER ->  ":---:"
      HorisontalAlignment.RIGHT ->   "----:"
      HorisontalAlignment.JUSTIFY -> "-----"
      }

  }

fun main() {
  val doc = document {
    section("*First* section version 1.1") {
      paragraph {
        text("A text")
        text("And one more", UNDERLINE)
        }
      paragraph("another text")
      java("""
        public class Person {
          private final int id;
          }
      """.trimIndent())
      list {
        item("First")
        item {
          text("The /Second/")
          text("*Second and a half*")
          }
        item("Third")
        list(Listing.Type.ARABIC) {
          section("In a list?") {
            paragraph("some content")
            }
          item("Uno")
          item("Due")
          item("Tre")
          }
        item("Fourth")
        }
      }
    section("Second") {
      paragraph { text("Lorem ipsum") }
      section {
        title = text {
          text("A very ")
          italic {
            text("cursive and ")
            code { text("code()") }
            text(" ")
            bold { text("BOLD") }
            }
          text(" decision")
          }
        }

      table {
        left("Full Name")
        center("Grade")
        right("Salary")
        /*
        column("Full Name")
        column("Grade", HorisontalAlignment.CENTER)
        column("Salary", HorisontalAlignment.RIGHT)
        */

        row {
          cell{ text("Kurt **Hansen** Bille") }
          cell("-3")
          cell("40.000")
          }
        row {
          cell("Sonja *Jensen*")
          cell("12")
          cell("30.000")
          }
        }

      }
    }
  //doc.print()


  MarkdownHandler(ConsoleHost()).handle(doc)
  }

