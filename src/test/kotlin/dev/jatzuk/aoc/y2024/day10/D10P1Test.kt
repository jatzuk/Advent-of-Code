package dev.jatzuk.aoc.y2024.day10

import dev.jatzuk.aoc.util.fromResourcesReadLines
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class D10P1Test : FunSpec({

  test("example") {
    val input = "/y2024/day10/part1/input0".fromResourcesReadLines()
    val result = D10P1().solution(input)
    result.shouldBe(36)
  }

  test("solution") {
    val input = "/y2024/day10/part1/input1".fromResourcesReadLines()
    val result = D10P1().solution(input)
    result.shouldBe(548)
  }
})
