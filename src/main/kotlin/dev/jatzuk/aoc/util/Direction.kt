package dev.jatzuk.aoc.util

enum class Direction(val dx: Int, val dy: Int) {
  LEFT(-1, 0),
  UP(0, -1),
  RIGHT(1, 0),
  DOWN(0, 1)
}
