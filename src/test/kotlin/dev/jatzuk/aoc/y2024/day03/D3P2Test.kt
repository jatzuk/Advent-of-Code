package dev.jatzuk.aoc.y2024.day03

import dev.jatzuk.aoc.util.fromResourcesReadLines
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class D3P2Test : FunSpec({

  test("example") {
    val input = "/y2024/day03/part2/input0".fromResourcesReadLines()
    val result = input.sumOf {
      D3P2().solution(it)
    }
    result.shouldBe(48)
  }

  test("solution") {
    val input = "/y2024/day03/part2/input1".fromResourcesReadLines()
    val result = D3P2().solution(input.joinToString())
    result.shouldBe(107069718)
  }
})
