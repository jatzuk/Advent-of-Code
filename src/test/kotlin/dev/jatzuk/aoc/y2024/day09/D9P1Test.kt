package dev.jatzuk.aoc.y2024.day09

import dev.jatzuk.aoc.util.fromResourcesReadLines
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class D9P1Test : FunSpec({

  test("example") {
    val input = "/y2024/day09/part1/input0".fromResourcesReadLines().joinToString().toList()
    val result = D9P1().solution(input)
    result.shouldBe(1928)
  }

  test("solution") {
    val input = "/y2024/day09/part1/input1".fromResourcesReadLines().joinToString().toList()
    val result = D9P1().solution(input)
    result.shouldBe(6395800119709)
  }
})
