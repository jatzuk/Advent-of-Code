package dev.jatzuk.aoc.y2024.day08

import dev.jatzuk.aoc.util.fromResourcesReadLines
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class D8P1Test : FunSpec({

  test("example") {
    val input = "/y2024/day08/part1/input0".fromResourcesReadLines()
    val result = D8P1().solution(input)
    result.shouldBe(14)
  }

  test("solution") {
    val input = "/y2024/day08/part1/input1".fromResourcesReadLines()
    val result = D8P1().solution(input)
    result.shouldBe(327)
  }
})
