package dev.jatzuk.aoc.y2024.day10

import dev.jatzuk.aoc.util.Direction
import dev.jatzuk.aoc.util.Point2D
import dev.jatzuk.aoc.util.isInside

class D10P2 {

  fun solution(input: List<String>): Int {
    val map = input.map {
      it.map { char ->
        char.digitToIntOrNull() ?: -1
      }
    }

    val trailHeads = buildList {
      map.forEachIndexed { y, cols ->
        cols.forEachIndexed { x, ceil ->
          if (ceil == 0) {
            add(Point2D(x, y))
          }
        }
      }
    }

    val ratings = mutableMapOf<Point2D, Int>()
    trailHeads.forEach { point ->
      val path = mutableListOf<Point2D>()
      val visited = mutableSetOf<Point2D>()
      map.dfs(point, visited, path, mutableListOf())
      ratings[point] = path.size
    }

    return ratings.values.sum()
  }

  private fun List<List<Int>>.dfs(
      position: Point2D,
      visited: MutableSet<Point2D>,
      path: MutableList<Point2D>,
      currentPath: MutableList<Point2D>
  ) {
    if (!position.isInside(this)) {
      return
    }

    if (position in visited) {
      return
    }

    val prevPosition = currentPath.lastOrNull()
    if (prevPosition != null && this[position.y][position.x] != this[prevPosition.y][prevPosition.x] + 1) {
      return
    }

    visited.add(position)
    currentPath.add(position)

    if (this[position.y][position.x] == 9) {
      path.add(position)
    }

    for (direction in Direction.entries) {
      dfs(position + direction, visited, path, currentPath)
    }

    currentPath.removeLast()
    visited.remove(position)
  }
}
