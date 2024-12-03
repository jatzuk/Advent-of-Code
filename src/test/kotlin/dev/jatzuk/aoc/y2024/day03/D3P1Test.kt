package dev.jatzuk.aoc.y2024.day03

import dev.jatzuk.aoc.y2024.fromResourcesReadLines
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class D3P1Test : FunSpec({

  test("example") {
    val input = "/y2024/day03/part1/input0".fromResourcesReadLines()
    val result = input.sumOf {
      D3P1().solution(it)
    }
    result.shouldBe(161)
  }

  test("solution") {
    val input = "/y2024/day03/part1/input1".fromResourcesReadLines()
    val result = input.sumOf {
      D3P1().solution(it)
    }
    result.shouldBe(189600467)
  }
})
