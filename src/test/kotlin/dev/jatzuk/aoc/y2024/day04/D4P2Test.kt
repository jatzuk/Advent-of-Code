package dev.jatzuk.aoc.y2024.day04

import dev.jatzuk.aoc.util.fromResourcesReadLines
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class D4P2Test : FunSpec({

  test("explanation") {
    val input = "/y2024/day04/part2/input".fromResourcesReadLines()
      .map(String::toList)
    val result = D4P2().solution(input)
    result.shouldBe(1)
  }

  test("example") {
    val input = "/y2024/day04/part2/input0".fromResourcesReadLines()
      .map(String::toList)
    val result = D4P2().solution(input)
    result.shouldBe(9)
  }

  test("solution") {
    val input = "/y2024/day04/part2/input1".fromResourcesReadLines()
      .map(String::toList)
    val result = D4P2().solution(input)
    result.shouldBe(1998)
  }
})
