package dev.jatzuk.aoc.y2024.day02

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class D2P1Test : FunSpec({

  test("example") {
    val input = D2InputReader.getInput("/y2024/day02/part1/input0")
    val result = D2P1().solution(input)
    result.shouldBe(2)
  }

  test("solution") {
    val input = D2InputReader.getInput("/y2024/day02/part1/input1")
    val result = D2P1().solution(input)
    result.shouldBe(257)
  }
})
