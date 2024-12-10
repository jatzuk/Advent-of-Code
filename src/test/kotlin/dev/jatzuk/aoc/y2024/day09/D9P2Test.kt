package dev.jatzuk.aoc.y2024.day09

import dev.jatzuk.aoc.util.fromResourcesReadLines
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class D9P2Test : FunSpec({

  test("example") {
    val input = "/y2024/day09/part2/input0".fromResourcesReadLines().joinToString().toList()
    val result = D9P2().solution(input)
    result.shouldBe(2858)
  }

  test("solution") {
    val input = "/y2024/day09/part2/input1".fromResourcesReadLines().joinToString().toList()
    val result = D9P2().solution(input)
    result.shouldBe(6418529470362)
  }
})
