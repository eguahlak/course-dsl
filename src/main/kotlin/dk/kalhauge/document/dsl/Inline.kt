package dk.kalhauge.document.dsl

interface Inline {
  fun nativeString(builder: StringBuilder)
  fun nativeString() = buildString { nativeString(this) }

  fun nakedString(builder: StringBuilder)
  fun nakedString() = buildString { nakedString(this) }
  }

