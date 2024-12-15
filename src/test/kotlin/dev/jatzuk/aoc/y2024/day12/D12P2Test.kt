package dev.jatzuk.aoc.y2024.day12

import dev.jatzuk.aoc.util.fromResourcesReadLines
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class D12P2Test : FunSpec({

  test("example") {
    val input = "/y2024/day12/part2/input0".fromResourcesReadLines()
    val result = D12P2().solution(input)
    result.shouldBe(1206)
  }

  test("solution") {
    val input = "/y2024/day12/part2/input1".fromResourcesReadLines()
    val result = D12P2().solution(input)
    result.shouldBe(902620)
  }
})
