package dev.jatzuk.aoc.y2024.day02

class D2P2 {

  fun solution(input: List<List<Int>>): Int {
    return input.toList().count { origin ->
      if (checkValues(origin)) {
        return@count true
      }

      origin.indices.any { originIndex ->
        val removed = origin.filterIndexed { index, _ -> index != originIndex }
        checkValues(removed)
      }
    }
  }

  private fun checkValues(input: List<Int>): Boolean {
    val isIncreasing = input.zipWithNext().all { (a, b) -> b > a && (b - a) in 1..3 }
    val isDecreasing = input.zipWithNext().all { (a, b) -> b < a && (a - b) in 1..3 }
    return isIncreasing || isDecreasing
  }
}
