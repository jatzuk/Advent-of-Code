package dev.jatzuk.aoc.y2024.day11

import dev.jatzuk.aoc.util.fromResourcesReadLines
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class D11P1Test : FunSpec({

  test("example") {
    val input = "/y2024/day11/part1/input0".fromResourcesReadLines().first()
    val result = D11P1().solution(input, 25)
    result.shouldBe(55312)
  }

  test("solution") {
    val input = "/y2024/day11/part1/input1".fromResourcesReadLines().first()
    val result = D11P1().solution(input, 25)
    result.shouldBe(194482)
  }
})
