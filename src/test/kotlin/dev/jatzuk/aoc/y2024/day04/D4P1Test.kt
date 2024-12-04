package dev.jatzuk.aoc.y2024.day04

import dev.jatzuk.aoc.util.fromResourcesReadLines
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class D4P1Test : FunSpec({

  test("explanation") {
    val input = "/y2024/day04/part1/input".fromResourcesReadLines()
      .map(String::toList)
    val result = D4P1().solution(input)
    result.shouldBe(4)
  }

  test("example") {
    val input = "/y2024/day04/part1/input0".fromResourcesReadLines()
      .map(String::toList)
    val result = D4P1().solution(input)
    result.shouldBe(18)
  }

  test("solution") {
    val input = "/y2024/day04/part1/input1".fromResourcesReadLines()
      .map(String::toList)
    val result = D4P1().solution(input)
    result.shouldBe(2569)
  }
})
