package dev.jatzuk.aoc.y2024.day05

import dev.jatzuk.aoc.util.fromResourcesReadLines
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class D5P2Test : FunSpec({

  test("example") {
    val input = "/y2024/day05/part2/input0".fromResourcesReadLines()
    val rules = input.takeWhile { it != "" }
      .map {
        val (a, b) = it.split("|").map(String::toInt)
        a to b
      }

    val updates = input.takeLastWhile { it != "" }
      .map {
        it.split(",").map(String::toInt)
      }

    val result = D5P2().solution(rules, updates)
    result.shouldBe(123)
  }

  test("solution") {
    val input = "/y2024/day05/part2/input1".fromResourcesReadLines()
    val rules = input.takeWhile { it != "" }
      .map {
        val (a, b) = it.split("|").map(String::toInt)
        a to b
      }

    val updates = input.takeLastWhile { it != "" }
      .map {
        it.split(",").map(String::toInt)
      }

    val result = D5P2().solution(rules, updates)
    result.shouldBe(6305)
  }
})
