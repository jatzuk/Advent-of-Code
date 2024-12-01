package dev.jatzuk.aoc.y2024

fun String.fromResourcesReadLines(): List<String> {
  return object {}.javaClass.getResourceAsStream(this)?.bufferedReader()?.readLines() ?: error("Failed to read file on path: $this")
}
