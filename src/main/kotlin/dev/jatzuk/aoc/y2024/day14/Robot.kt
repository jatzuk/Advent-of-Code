package dev.jatzuk.aoc.y2024.day14

import dev.jatzuk.aoc.util.Point2D
import dev.jatzuk.aoc.util.Vector2D

class Robot(
  var position: Point2D,
  private val vector2D: Vector2D
) {

  fun moveToEnd(width: Int, height: Int, iterations: Int) {
    val x = (position.x + vector2D.x.toInt() * iterations).mod(width)
    val y = (position.y + vector2D.y.toInt() * iterations).mod(height)
    this.position = Point2D(x, y)
  }

  fun move(width: Int, height: Int) {
    val x = (position.x + vector2D.x.toInt()).mod(width)
    val y = (position.y + vector2D.y.toInt()).mod(height)
    this.position = Point2D(x, y)
  }
}
