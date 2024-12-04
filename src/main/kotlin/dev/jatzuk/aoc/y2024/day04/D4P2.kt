package dev.jatzuk.aoc.y2024.day04

class D4P2 {

  fun solution(input: List<List<Char>>): Int {
    var acc = 0

    for (col in 1 until input.size) {
      for (row in 1 until input[col].size) {
        if (input[col][row] == 'A') {
          if (input.checkDiagonals(col, row)) {
            acc++
          }
        }
      }
    }

    return acc
  }

  private fun List<List<Char>>.checkDiagonals(col: Int, row: Int): Boolean {
    val topLeft = getOrNull(col - 1)?.getOrNull(row - 1)
    val topRight = getOrNull(col - 1)?.getOrNull(row + 1)
    val bottomLeft = getOrNull(col + 1)?.getOrNull(row - 1)
    val bottomRight = getOrNull(col + 1)?.getOrNull(row + 1)

    return (topLeft == 'M' && bottomLeft == 'M' && topRight == 'S' && bottomRight == 'S') ||
      (topLeft == 'S' && bottomLeft == 'M' && topRight == 'S' && bottomRight == 'M') ||
      (topLeft == 'M' && bottomLeft == 'S' && topRight == 'M' && bottomRight == 'S') ||
      (topLeft == 'S' && bottomLeft == 'S' && topRight == 'M' && bottomRight == 'M')
  }
}
