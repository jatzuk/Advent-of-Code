package dev.jatzuk.aoc.y2024.day12

import dev.jatzuk.aoc.y2024.util.Direction
import dev.jatzuk.aoc.y2024.util.Point2D
import dev.jatzuk.aoc.y2024.util.isInside

class D12P1 {

  fun solution(input: List<String>): Int {
    val grid = input.map { it.toList() }
    val visited = mutableListOf<Point2D>()

    var acc = 0
    input.forEachIndexed { y, row ->
      row.forEachIndexed { x, _ ->
        val point = Point2D(y, x)
        if (point !in visited) {
          val (area, perimeter) = grid.bfs(point, visited)
          acc += area * perimeter
        }
      }
    }

    return acc
  }

  private fun List<List<Char>>.bfs(position: Point2D, visited: MutableList<Point2D>): Pair<Int, Int> {
    val queue = ArrayDeque<Point2D>()

    queue.add(position)
    visited.add(position)

    var area = 0
    var perimeter = 0
    val char = this[position.y][position.x]

    while (queue.isNotEmpty()) {
      val current = queue.removeFirst()
      area++

      Direction.entries.forEach { direction ->
        val neighborPoint = current + direction

        if (!neighborPoint.isInside(this)) {
          perimeter++
        } else if (char != this.getOrNull(neighborPoint.y)?.getOrNull(neighborPoint.x)) {
          perimeter++
        } else if (neighborPoint !in visited) {
          queue.add(neighborPoint)
          visited.add(neighborPoint)
        }
      }
    }

    return area to perimeter
  }
}
