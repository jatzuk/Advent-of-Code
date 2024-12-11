package dev.jatzuk.aoc.y2024.day11

import dev.jatzuk.aoc.util.fromResourcesReadLines
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class D11P2Test : FunSpec({

  test("solution") {
    val input = "/y2024/day11/part2/input1".fromResourcesReadLines().first()
    val result = D11P2().solution(input, 75)
    result.shouldBe(232454623677743)
  }
})
