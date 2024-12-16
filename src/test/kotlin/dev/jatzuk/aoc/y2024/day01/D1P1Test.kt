package dev.jatzuk.aoc.y2024.day01

import dev.jatzuk.aoc.util.fromResourcesReadLines
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class D1P1Test : FunSpec({

  test("example") {
    val (left, right) = getInput("/y2024/day01/part1/input0")
    val result = D1P1().solution(left.toLongArray(), right.toLongArray())
    result.shouldBe(11)
  }

  test("solution") {
    val (left, right) = getInput("/y2024/day01/part1/input1")
    val result = D1P1().solution(left.toLongArray(), right.toLongArray())
    result.shouldBe(2192892)
  }
})

private fun getInput(path: String): Pair<List<Long>, List<Long>> {
  val left = mutableListOf<Long>()
  val right = mutableListOf<Long>()

  path.fromResourcesReadLines()
    .map {
      val (leftNumber, rightNumber) = it.split("\\s".toRegex()).filter(String::isNotEmpty)
      leftNumber.toLong() to rightNumber.toLong()
    }
    .forEach {
      left.add(it.first)
      right.add(it.second)
    }

  return left to right
}

