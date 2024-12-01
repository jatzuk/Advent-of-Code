package dev.jatzuk.aoc.y2024.day01

import dev.jatzuk.aoc.y2024.fromResourcesReadLines
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Part1Test : FunSpec({

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
    val (left, right) = getInputs("/y2024/day01/part1/input0")
    val result = Part1().solution(left.toLongArray(), right.toLongArray())
    result.shouldBe(11)
  }

  test("solution") {
    val (left, right) = getInputs("/y2024/day01/part1/input1")
    val result = Part1().solution(left.toLongArray(), right.toLongArray())
    result.shouldBe(2192892)
  }
})
