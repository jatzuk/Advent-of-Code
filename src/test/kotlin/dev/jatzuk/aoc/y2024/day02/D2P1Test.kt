package dev.jatzuk.aoc.y2024.day02

import dev.jatzuk.aoc.y2024.fromResourcesReadLines
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class D2P1Test : FunSpec({

  fun getInput(path: String): Array<IntArray> {
    return path.fromResourcesReadLines()
      .map { it.split("\\s".toRegex()) }
      .map {
        it.map {
          it.toInt()
        }.toIntArray()
      }.toTypedArray()
  }

  test("example") {
    val input = getInput("/y2024/day02/part1/input0")
    val result = D2P1().solution(input)
    result.shouldBe(2)
  }

  test("solution") {
    val input = getInput("/y2024/day02/part1/input1")
    val result = D2P1().solution(input)
    result.shouldBe(257)
  }
})
