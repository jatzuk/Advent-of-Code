package dev.jatzuk.aoc.y2024.day01

import kotlin.math.abs

class D1P1 {

  fun solution(left: LongArray, right: LongArray): Long {
    val leftSorted = left.sorted()
    val rightSorted = right.sorted()
    var sum = 0L

    leftSorted.forEachIndexed { index, leftN ->
      sum += abs(leftN - rightSorted[index])
    }

    return sum
  }
}
