package dev.jatzuk.aoc.y2024.day05

import dev.jatzuk.aoc.util.fromResourcesReadLines
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class D5P1Test : FunSpec({

  test("example") {
    val input = "/y2024/day05/part1/input0".fromResourcesReadLines()
    val rules = input.takeWhile { it != "" }
      .map {
        val (a, b) = it.split("|").map(String::toInt)
        a to b
      }

    val updates = input.takeLastWhile { it != "" }
      .map {
        it.split(",").map(String::toInt)
      }

    val result = D5P1().solution(rules, updates)
    result.shouldBe(143)
  }

  test("solution") {
    val input = "/y2024/day05/part1/input1".fromResourcesReadLines()
    val rules = input.takeWhile { it != "" }
      .map {
        val (a, b) = it.split("|").map { it.toInt() }
        a to b
      }

    val updates = input.takeLastWhile { it != "" }
      .map {
        it.split(",").map { it.toInt() }
      }

    val result = D5P1().solution(rules, updates)
   result.shouldBe(6034)
  }
})
