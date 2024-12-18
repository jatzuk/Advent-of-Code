package dev.jatzuk.aoc.y2024.day14

import dev.jatzuk.aoc.util.Point2D
import dev.jatzuk.aoc.util.Vector2D
import dev.jatzuk.aoc.util.fromResourcesReadLines
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class D14P1Test : FunSpec({

  test("example") {
    val input = "/y2024/day14/part1/input0".fromResourcesReadLines()
      .map {
        val (x, y) = it.substringAfter("p=").substringBefore("v").trim().split(",").map { it.toInt() }
        val (dx, dy) = it.substringAfter("v=").trim().split(",").map { it.toInt() }
        Robot(Point2D(x, y), Vector2D(dx, dy))
      }
    val result = D14P1().solution(11, 7, input, 100)
    result.shouldBe(12)
  }

  test("solution") {
    val input = "/y2024/day14/part1/input1".fromResourcesReadLines()
      .map {
        val (x, y) = it.substringAfter("p=").substringBefore("v").trim().split(",").map { it.toInt() }
        val (dx, dy) = it.substringAfter("v=").trim().split(",").map { it.toInt() }
        Robot(Point2D(x, y), Vector2D(dx, dy))
      }

    val result = D14P1().solution(101, 103 ,input, 100)
    result.shouldBe(233709840)
  }
})
