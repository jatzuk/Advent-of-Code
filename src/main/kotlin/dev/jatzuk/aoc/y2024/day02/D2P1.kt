package dev.jatzuk.aoc.y2024.day02

import kotlin.math.abs

class D2P1 {

  fun solution(input: Array<IntArray>): Int = input.count { checkValues(it.toList()) }

  private fun checkValues(input: List<Int>): Boolean {
    val increaseCount = input.zipWithNext().count { (a, b) -> a < b }
    val decreaseCount = input.zipWithNext().count { (a, b) -> a > b }

    val isIncreasing = increaseCount == input.lastIndex
    val isDecreasing = decreaseCount == input.lastIndex

    if (!isIncreasing && !isDecreasing) {
      return false
    }

    input
      .drop(1)
      .scan(input.first()) { acc, i ->
        val diff = abs(acc - i)
        if (diff > 3) {
          return false
        }
        i
      }

    return true
  }
}
