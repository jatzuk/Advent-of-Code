package dev.jatzuk.aoc.y2024.day02

import dev.jatzuk.aoc.util.fromResourcesReadLines

object D2InputReader {
  fun getInput(path: String): List<List<Int>> = path.fromResourcesReadLines()
    .map { it.split("\\s".toRegex()) }
    .map { it.map(String::toInt) }
}
