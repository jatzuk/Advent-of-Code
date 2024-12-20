package dev.jatzuk.aoc.y2024.day01

import dev.jatzuk.aoc.util.fromResourcesReadLines
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class D1P2Test : FunSpec({

  fun getInputs(path: String): Pair<List<Long>, List<Long>> {
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

  test("example") {
    val (left, right) = getInputs("/y2024/day01/part2/input0")
    val result = D1P2().solution(left.toLongArray(), right.toLongArray())
    result.shouldBe(31)
  }

  test("solution") {
    val (left, right) = getInputs("/y2024/day01/part2/input1")
    val result = D1P2().solution(left.toLongArray(), right.toLongArray())
    result.shouldBe(22962826)
  }
})
