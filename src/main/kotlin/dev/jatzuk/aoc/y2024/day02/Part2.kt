package dev.jatzuk.aoc.y2024.day02

class Part2 {

  fun solution(input: Array<IntArray>): Int {
    return input.toList().count {
      if (checkValues(it.toList())) {
        return@count true
      }

      it.indices.any { index ->
        val modified = it.filterIndexed { filterIndex, i -> filterIndex != index }
        checkValues(modified)
      }
    }
  }

  private fun checkValues(input: List<Int>): Boolean {
    val isIncreasing = input.zipWithNext().all { (a, b) -> b > a && (b - a) in 1..3 }
    val isDecreasing = input.zipWithNext().all { (a, b) -> b < a && (a - b) in 1..3 }
    return isIncreasing || isDecreasing
  }
}
