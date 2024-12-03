package dev.jatzuk.aoc.util

fun String.fromResourcesReadLines(): List<String> {
  return object {}.javaClass.getResourceAsStream(this)?.bufferedReader()?.readLines() ?: error("Failed to read file on path: $this")
}
