package dk.kalhauge.util

infix fun Int.of(text: String) = (1..this).map { text }.joinToString(separator = "")

val String.back: String get() = this.replace("[^/]+".toRegex(), "..")

/*
fun main() {
  println("week-06/info".back)
  }
*/