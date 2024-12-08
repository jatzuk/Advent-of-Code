package dev.jatzuk.aoc.y2024.day07

import dev.jatzuk.aoc.util.fromResourcesReadLines
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class D7P2Test : FunSpec({

  test("example") {
    val input = "/y2024/day07/part2/input0".fromResourcesReadLines()
    val result = D7P2().solution(input)
    result.shouldBe(11387)
  }

  test("solution") {
    val input = "/y2024/day07/part2/input1".fromResourcesReadLines()
    val result = D7P2().solution(input)
    result.shouldBe(70597497486371)
  }
})
