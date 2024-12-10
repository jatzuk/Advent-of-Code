package dev.jatzuk.aoc.y2024.util

data class Point2D(val x: Int, val y: Int) {

  operator fun plus(direction: Direction): Point2D {
    return Point2D(x + direction.dx, y + direction.dy)
  }
}

fun Point2D.isInside(map: List<List<Int>>): Boolean {
  return y in map.indices && x in map[0].indices
}
