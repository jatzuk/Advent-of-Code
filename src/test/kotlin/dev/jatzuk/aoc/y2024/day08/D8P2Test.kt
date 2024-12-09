package dev.jatzuk.aoc.y2024.day08

import dev.jatzuk.aoc.util.fromResourcesReadLines
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class D8P2Test : FunSpec({

  test("example") {
    val input = "/y2024/day08/part2/input0".fromResourcesReadLines()
    val result = D8P2().solution(input)
    result.shouldBe(34)
  }

  test("solution") {
    val input = "/y2024/day08/part2/input1".fromResourcesReadLines()
    val result = D8P2().solution(input)
    result.shouldBe(1233)
  }
})
