package dev.jatzuk.aoc.y2024.day14

class D14P2 {

  fun solution(width: Int, height: Int, robots: List<Robot>): Int {
    var iteration = 0

    while (iteration++ < 10_000) {
      robots.forEach {
        it.move(width, height)
      }

      val sameRowSize = robots.groupBy { it.position.x }.maxOf { it.value.size }
      val sameColumnSize = robots.groupBy { it.position.y }.maxOf { it.value.size }
      if (sameColumnSize >= 31 && sameRowSize >= 31) {
        return iteration
      }
    }

    return -1
  }
}
