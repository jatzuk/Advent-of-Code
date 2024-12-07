package dev.jatzuk.aoc.y2024.day06

import dev.jatzuk.aoc.util.fromResourcesReadLines
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class D6P1Test : FunSpec({

  test("example") {
    val input = "/y2024/day06/part1/input0".fromResourcesReadLines()
    val result = D6P1().solution(input)
    result.shouldBe(41)
  }

  test("solution") {
    val input = "/y2024/day06/part1/input1".fromResourcesReadLines()
    val result = D6P1().solution(input)
    result.shouldBe(4454)
  }
})
