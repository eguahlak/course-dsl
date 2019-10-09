package dk.kalhauge.course.printers

import dk.kalhauge.util.stackOf
import java.io.File
import java.io.PrintWriter

interface Context {
  fun printLine(text: String?, emptyLineCount: Int = 1)
  fun open(filename: String)
  fun close()
  }

class ConsoleContext() : Context {
  val filenames = stackOf<String>()

  override fun printLine(text: String?, emptyLineCount: Int) {
    if (text == null) return
    println(text)
    for (i in 1 until emptyLineCount) println()
    }

  override fun open(filename: String) {
    filenames.push(filename)
    println(">>> OPEN : $filename")
    }

  override fun close() {
    println("<<< CLOSE: ${filenames.pop()}")
    }

  }

class FileContext(val rootPath: String) : Context {
  val root = File(rootPath)
  val outputs = stackOf<PrintWriter>()

  init {
    // root should be a directory and should exist
    if (!root.isDirectory) throw IllegalArgumentException("$rootPath should point to existing directory")
    }

  override fun printLine(text: String?, emptyLineCount: Int) {
    // top file's active writer should never be null
    if (text == null) return
    with (outputs.peek()) {
      println(text)
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