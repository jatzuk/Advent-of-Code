package dev.jatzuk.aoc.util

@Throws(IllegalStateException::class)
fun String.fromResourcesReadLines(): List<String> {
  val resource = object {}.javaClass.getResourceAsStream(this) ?: error("Failed to read file $this")
  return resource.bufferedReader().readLines()
}
