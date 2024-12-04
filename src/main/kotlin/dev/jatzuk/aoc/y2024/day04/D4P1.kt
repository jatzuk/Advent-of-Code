package dev.jatzuk.aoc.y2024.day04

class D4P1 {

  fun solution(input: List<List<Char>>): Int {
    var acc = 0

    for (col in input.indices) {
      for (row in input[col].indices) {

        for ((dy, dx) in directions) {
          val isFound = input.checkDirection(col, row, dy, dx, "XMAS")
          if (isFound) {
            acc++
          }
        }
      }
    }

    return acc
  }

  private fun List<List<Char>>.checkDirection(col: Int, row: Int, dy: Int, dx: Int, lookup: String): Boolean {
    for (i in lookup.indices) {
      val y = col + i * dy
      val x = row + i * dx

      val char = getOrNull(y)?.getOrNull(x)
      if (char != lookup[i]) {
        return false
      }
    }

    return true
  }

  private companion object {
    val directions = (-1..1)
      .flatMap { y ->
      (-1..1)
        .mapNotNull { x ->
          (y to x).takeIf { it != 0 to 0 }
        }
    }
  }
}
