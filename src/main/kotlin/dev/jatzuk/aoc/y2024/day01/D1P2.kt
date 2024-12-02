package dev.jatzuk.aoc.y2024.day01

class D1P2 {

  fun solution(left: LongArray, right: LongArray): Long {
    val rightMap = right.associateWith { n -> right.count { n == it } }

    return left.fold(0) { acc, value ->
      val m = value * rightMap.getOrDefault(value, 0)
      acc + m
    }
  }
}
