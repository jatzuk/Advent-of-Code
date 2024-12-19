package dev.jatzuk.aoc.y2024.day15

import dev.jatzuk.aoc.util.Direction
import dev.jatzuk.aoc.util.Point2D

class D15P1 {

  fun solution(grid: Array<CharArray>, moves: List<Direction>): Long {
    simulateGrid(grid, moves)
    return grid.countGPS()
  }

  fun simulateGrid(grid: Array<CharArray>, moves: List<Direction>) {
    var actorPosition = Point2D(0, 0)

    grid.forEachIndexed outer@{ y, row ->
      row.forEachIndexed { x, char ->
        if (char == '@') {
          actorPosition = Point2D(x, y)
          return@outer
        }
      }
    }

    moves.forEach { move ->
      val (x, y) = actorPosition
      val (tx, ty) = actorPosition + move
      val neighbor = grid.getOrNull(ty)?.getOrNull(tx)

      when(neighbor) {
        '.' -> {
          actorPosition += move
          grid[y][x] = '.'
          grid[ty][tx] = '@'
        }

        'O' -> {
          var aligned = 0
          val dx = move.dx
          val dy = move.dy
          var nx = tx
          var ny = ty

          while (true) {
            when(grid.atOrNull(nx, ny)) {
              'O' -> {
                aligned++
                nx += dx
                ny += dy
              }

              '#' -> {
                aligned = -1
                break
              }

              else -> {
                break
              }
            }
          }

          if (aligned > 0) {
            val boxes = mutableListOf<Point2D>()
            nx = tx
            ny = ty

            repeat(aligned) {
              boxes.add(Point2D(nx, ny))
              nx += dx
              ny += dy
            }

            for ((ox, oy) in boxes.reversed()) {
              val nextX = ox + dx
              val nextY = oy + dy
              grid[oy][ox] = '.'
              grid[nextY][nextX] = 'O'
            }

            actorPosition += move
            grid[y][x] = '.'
            grid[ty][tx] = '@'
          }
        }
      }
    }
  }

  private fun Array<CharArray>.countGPS(): Long {
    var acc = 0L
    for (y in indices) {
      for (x in this[y].indices) {
        val char = this[y][x]
        if (char == 'O') {
          val value = 100 * y + x
          acc += value
        }
      }
    }
    return acc
  }

  private fun Array<CharArray>.atOrNull(x: Int, y: Int): Char? = getOrNull(y)?.getOrNull(x)
}
