package dev.jatzuk.aoc.y2024.day12

import dev.jatzuk.aoc.y2024.util.Direction
import dev.jatzuk.aoc.y2024.util.Point2D
import dev.jatzuk.aoc.y2024.util.isAdjacentTo
import dev.jatzuk.aoc.y2024.util.isInside

class D12P2 {

  fun solution(input: List<String>): Long {
    val grid = input.map { it.toList() }
    val visited = mutableListOf<Point2D>()
    val figures = mutableListOf<Figure>()

    input.forEachIndexed { y, row ->
      for (x in row.indices) {
        val point = Point2D(y, x)
        if (point !in visited && point !in figures.flatMap(Figure::items)) {
          grid.bfs(point, visited, figures)
          visited.clear()
        }
      }
    }

    return grid.countSides(figures)
  }

  private fun List<List<Char>>.countSides(figures: MutableList<Figure>): Long {
    return figures
      .map { figure ->
        figure.items.distinct().sortedWith(compareBy({ it.x }, { it.y }))
      }
      .sumOf { points ->
        val checkMap = mutableMapOf<Point2D, MutableSet<Direction>>()

        val char = with(points.first()) { this@countSides.getOrNull(y)?.getOrNull(x) }
        var sides = 0

        points.forEach { point ->
          for (direction in Direction.entries) {
            val check = point + direction

            val isInside = check.isInside(this)
            val isSameChar = this.getOrNull(check.y)?.getOrNull(check.x) == char

            val adjustedPoints = checkMap.keys
              .filter { it != point && check.isAdjacentTo(it) }

            val cameFrom = adjustedPoints
              .mapNotNull { checkMap[it] }
              .flatten()

            if ((!isInside || !isSameChar) && direction !in cameFrom) {
              sides++
            }

            val directions = checkMap.getOrPut(check) { mutableSetOf() }
            if (!isSameChar) {
              directions.add(direction)
            }
          }
        }

        points.size.toLong() * sides
      }
  }

  private fun List<List<Char>>.bfs(
    position: Point2D,
    visited: MutableList<Point2D>,
    figures: MutableList<Figure>
  ) {
    val queue = ArrayDeque<Point2D>()
    queue.add(position)
    visited.add(position)

    val figure = Figure(mutableListOf(position))
    figures.add(figure)

    while (queue.isNotEmpty()) {
      val current = queue.removeFirst()
      val char = this.getOrNull(current.y)?.getOrNull(current.x)

      Direction.entries.forEach { direction ->
        val neighborPoint = current + direction

        if (neighborPoint.isInside(this)) {
          if (neighborPoint !in visited) {
            if (char == this.getOrNull(neighborPoint.y)?.getOrNull(neighborPoint.x)) {
              figure.items.add(neighborPoint)
              queue.add(neighborPoint)
              visited.add(neighborPoint)
            }
          }
        }
      }
    }
  }

  private data class Figure(val items: MutableList<Point2D>)
}
