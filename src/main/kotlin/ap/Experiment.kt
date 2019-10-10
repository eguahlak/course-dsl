package ap

import java.io.File

fun main() {
  val file = File("/Users/AKA/experiment/docs/notes.txt")
  val root = file.parentFile
  println(root)
  root.mkdirs()
  file.delete()
  file.createNewFile()
  with (file.printWriter()) {
    println("Hello World")
    close()
    }

  }