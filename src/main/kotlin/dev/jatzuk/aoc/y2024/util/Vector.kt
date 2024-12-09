package dev.jatzuk.aoc.y2024.util

import kotlin.math.sqrt

data class Vector2D(val x: Double, val y: Double) {

  constructor(x: Number, y: Number) : this(x.toDouble(), y.toDouble())

  operator fun plus(other: Vector2D): Vector2D {
    return Vector2D(x + other.x, y + other.y)
  }

  operator fun minus(other: Vector2D): Vector2D {
    return Vector2D(x - other.x, y - other.y)
  }

  operator fun times(scalar: Int): Vector2D {
    return Vector2D(x * scalar, y * scalar)
  }

  operator fun div(scalar: Double): Vector2D {
    return Vector2D(x / scalar, y / scalar)
  }

  fun distance(other: Vector2D): Double {
    val x = x - other.x
    val y = y - other.y
    return sqrt(x * x + y * y)
  }

  fun length(): Double {
    return sqrt(x * x + y * y)
  }

  fun normalized(): Vector2D {
    val magnitude = length()
    return Vector2D(x / magnitude, y / magnitude)
  }
}

fun Vector2D.isInside(grid: List<String>): Boolean {
  return isInside(width = grid[0].length, height = grid.size)
}

fun Vector2D.isInside(width: Int, height: Int): Boolean {
  return x.toInt() in 0 until width && y.toInt() in 0  until height
}
