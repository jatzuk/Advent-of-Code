package dev.jatzuk.aoc.y2024.day14

import dev.jatzuk.aoc.util.Point2D

class D14P1 {

  fun solution(width: Int, height: Int, robots: List<Robot>, iterations: Int): Long {
    robots.forEach {
      it.move(width, height, iterations)
    }

    val centerX = width / 2
    val centerY = height / 2

    return robots.groupBy {
      val (x, y) = it.position
      when {
        x < centerX && y < centerY -> 0
        x > centerX && y < centerY -> 1
        x < centerX && y > centerY -> 2
        x > centerX && y > centerY -> 3
        else -> -1
      }
    }
      .filterKeys { it > -1 }
      .map { it.value.count() }
      .fold(1L, Long::times)
  }

  private fun Robot.move(width: Int, height: Int, iterations: Int) {
    val x = (position.x + vector2D.x.toInt() * iterations).mod(width)
    val y = (position.y + vector2D.y.toInt() * iterations).mod(height)
    this.position = Point2D(x, y)
  }
}
