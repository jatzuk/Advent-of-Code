package dev.jatzuk.aoc.y2024.day06

class D6P1 {

  fun solution(input: List<String>): Int {
    val height = input.size
    val width = input[0].length

    var guardPosition = 0 to 0
    var direction = Direction.UP

    val obstacles = mutableListOf<Pair<Int, Int>>()
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

    visited.add(guardPosition)

    while (guardPosition.first in 0..<height && guardPosition.second in 0..<width) {
      val delta = direction.vector
      val hasObstacle = (guardPosition.first + delta.first to guardPosition.second + delta.second) in obstacles
      if (!hasObstacle) {
        guardPosition = (guardPosition.first + delta.first to guardPosition.second + delta.second)
        visited.add(guardPosition)
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
