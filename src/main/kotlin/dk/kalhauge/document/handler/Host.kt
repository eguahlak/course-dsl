package dk.kalhauge.document.handler

import dk.kalhauge.util.of
import dk.kalhauge.util.stackOf
import java.io.File
import java.io.PrintWriter

interface Host {
  var indent: Int
  fun print(text: String?)
  fun printLine(text: String?, emptyLineCount: Int = 1)
  fun open(filename: String)
  fun close()
  fun printLine() { printLine("", 0) }
  fun printLine(prefix: String, text: String?, emptyLineCount: Int = 1) {
    if (text != null) printLine("$prefix $text", emptyLineCount)
    }
  }

class ConsoleHost() : Host {
  val filenames = stackOf<String>()

  override var indent: Int = 0
    get() = field
    set(value) {
      field = value
      if (field < 0) throw IllegalArgumentException("Indent can't be negative")
      }

  override fun print(text: String?) {
    if (text == null) return
    kotlin.io.print(text)
    }

  override fun printLine(text: String?, emptyLineCount: Int) {
    if (text == null) return
    println("${indent of " "}$text")
    for (i in 1..emptyLineCount) println()
    }

  override fun open(filename: String) {
    filenames.push(filename)
    println(">>> OPEN : $filename")
    }

  override fun close() {
    println("<<< CLOSE: ${filenames.pop()}")
    }

  }

class FileHost(val rootPath: String) : Host {
  val root = File(rootPath)
  val outputs = stackOf<PrintWriter>()

  override var indent: Int = 0
    get() = field
    set(value) {
      field = value
      if (field < 0) throw IllegalArgumentException("Indent can't be negative")
      }
  init {
    // root should be a directory and should exist
    if (!root.isDirectory) throw IllegalArgumentException("$rootPath should point to existing directory")
    }

  override fun print(text: String?) {
    if (text == null) return
    print(text)
    }

  override fun printLine(text: String?, emptyLineCount: Int) {
    // top file's active writer should never be null
    if (text == null) return
    with (outputs.peek()) {
      println("${indent of " "}$text")
      for (i in 1..emptyLineCount) println()
      }
    }

  override fun open(filename: String) {
    val file = File(rootPath, filename)
    val parent = file.parentFile
    parent.mkdirs()
    file.delete()
    file.createNewFile()
    outputs.push(file.printWriter())
    }

  override fun close() {
    outputs.pop().close()
    }

  }