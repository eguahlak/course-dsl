package dk.kalhauge.util

infix fun Int.of(text: String) = (1..this).map { text }.joinToString(separator = "")
