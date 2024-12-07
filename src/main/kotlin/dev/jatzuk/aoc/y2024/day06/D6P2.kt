package dev.jatzuk.aoc.y2024.day06

class D6P2 {

  fun solution(input: List<String>): Int {
    val height = input.size
    val width = input[0].length

    val obstacles = mutableListOf<Pair<Int, Int>>()

    var guardPosition = 0 to 0
    var direction = Direction.UP

    val visited = mutableSetOf<Pair<Int, Int>>()

    input.forEachIndexed { y, line ->
      line.forEachIndexed { x, c ->
        when (c) {
          '#' -> {
            obstacles.add(y to x)
          }

          '^' -> {
            guardPosition = y to x
            direction = Direction.UP
          }

          '>' -> {
            guardPosition = y to x
            direction = Direction.RIGHT
          }

          'v' -> {
            guardPosition = y to x
            direction = Direction.DOWN
          }

          '<' -> {
            guardPosition = y to x
            direction = Direction.LEFT
          }
        }
      }
    }

    val initialGuardPosition = Pair(guardPosition.first, guardPosition.second)

    var acc = 0

    for ((y, line) in input.withIndex()) {
      for (x in line.indices) {
        guardPosition = initialGuardPosition
        visited.add(guardPosition)

        val point = y to x
        if (point !in obstacles && point != guardPosition) {
          obstacles.add(point)

          val result = solve(height, width, guardPosition, direction, visited, obstacles)
          if (result == null) {
            acc++
          }

          obstacles.remove(point)
        }

        visited.clear()
      }
    }

    return acc
  }

  private fun solve(
    height: Int,
    width: Int,
    guardPosition: Pair<Int, Int>,
    direction: Direction,
    visited: MutableSet<Pair<Int, Int>>,
    obstacles: List<Pair<Int, Int>>
  ): Int? {
    var guardPosition = guardPosition
    var direction = direction

    var i = 0
    while (guardPosition.first in 0..<height && guardPosition.second in 0..<width) {
      val delta = direction.vector

      val next = guardPosition.first + delta.first to guardPosition.second + delta.second
      val hasObstacle = next in obstacles
      if (!hasObstacle) {
        guardPosition = (guardPosition.first + delta.first to guardPosition.second + delta.second)
        val wasAdded = visited.add(guardPosition)
        if (wasAdded) {
          i = 0
        } else if (i++ >= visited.size) {
          return null
        }
      } else {
        val index = (direction.ordinal + 1) % Direction.entries.size
        direction = Direction.entries[index]
      }
    }

    return visited.size - 1
  }

  private enum class Direction(val vector: Pair<Int, Int>) {
    UP(-1 to 0),
    RIGHT(0 to 1),
    DOWN(1 to 0),
    LEFT(0 to -1)
  }
}
