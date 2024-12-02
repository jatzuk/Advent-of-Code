package dev.jatzuk.aoc.y2024.day02

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class D2P2Test : FunSpec({

  test("example") {
    val input = D2InputReader.getInput("/y2024/day02/part2/input0")
    val result = D2P2().solution(input)
    result.shouldBe(4)
  }

  test("solution") {
    val input = D2InputReader.getInput("/y2024/day02/part2/input1")
    val result = D2P2().solution(input)
    result.shouldBe(328)
  }
})
