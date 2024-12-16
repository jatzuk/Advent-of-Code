package dev.jatzuk.aoc.y2024.day13

import dev.jatzuk.aoc.util.Point2D
import dev.jatzuk.aoc.util.Vector2D
import dev.jatzuk.aoc.util.fromResourcesReadLines
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class D13P1Test : FunSpec({

  test("example") {
    val machines = getInput("/y2024/day13/part1/input0")
    val result = D13P1().solution(machines, 100)
    result.shouldBe(480)
  }

  test("solution") {
    val machines = getInput("/y2024/day13/part1/input1")
    val result = D13P1().solution(machines, 100)
    result.shouldBe(29711L)
  }
})

private fun getInput(path: String): List<ClawMachine> {
  val input = path.fromResourcesReadLines()
    .filterNot { it.isEmpty() }
    .chunked(3)

  val machines = input.map { lines ->
    val (xA, yA) = lines[0].substringAfter(":").split(",").map { it.removeRange(0, 3).toInt() }
    val (xB, yB) = lines[1].substringAfter(":").split(",").map { it.removeRange(0, 3).toInt() }
    val (xT, yT) = lines[2].substringAfter(":").split(",").map { it.removeRange(0, 3).toInt() }

    ClawMachine(Vector2D(xA, yA), Vector2D(xB, yB), Point2D(xT, yT))
  }
  return machines
}
