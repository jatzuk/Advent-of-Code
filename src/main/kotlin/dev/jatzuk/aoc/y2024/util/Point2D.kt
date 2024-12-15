package dev.jatzuk.aoc.y2024.util

import kotlin.math.abs

data class Point2D(val x: Int, val y: Int) {

  operator fun plus(direction: Direction): Point2D {
    return Point2D(x + direction.dx, y + direction.dy)
  }
}

fun <T> Point2D.isInside(map: Collection<Collection<T>>): Boolean {
  return y in map.indices && x in map.first().indices
}

fun Point2D.isAdjacentTo(other: Point2D): Boolean {
  return (abs(x - other.x) == 1 && y == other.y) || (abs(y - other.y) == 1 && x == other.x)
}
