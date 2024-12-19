package dev.jatzuk.aoc.y2024.day15

import dev.jatzuk.aoc.util.Direction
import dev.jatzuk.aoc.util.fromResourcesReadLines
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class D15P1Test : FunSpec({

  test("simple check position") {
    val (grid, moves) = parseInput("/y2024/day15/part1/input")
    D15P1().simulateGrid(grid, moves)
    val result = grid.joinToString("\n") { it.joinToString("") }
    val outputTarget = "/y2024/day15/part1/output_simple_check_position".fromResourcesReadLines().joinToString("\n")
    result.shouldBe(outputTarget)
  }

  test("example check position") {
    val (grid, moves) = parseInput("/y2024/day15/part1/input0")
    D15P1().simulateGrid(grid, moves)
    val result = grid.joinToString("\n") { it.joinToString("") }
    val outputTarget = "/y2024/day15/part1/output_example_check_position".fromResourcesReadLines().joinToString("\n")
    result.shouldBe(outputTarget)
  }

  test("example gps small") {
    val (grid, moves) = parseInput("/y2024/day15/part1/input")
    val result = D15P1().solution(grid, moves)
    result.shouldBe(2028)
  }

  test("example") {
    val (grid, moves) = parseInput("/y2024/day15/part1/input0")
    val result = D15P1().solution(grid, moves)
    result.shouldBe(10092)
  }

  test("solution") {
    val (grid, moves) = parseInput("/y2024/day15/part1/input1")
    val result = D15P1().solution(grid, moves)
    result.shouldBe(1475249)
  }
})

private fun parseInput(path: String): Pair<Array<CharArray>, List<Direction>> {
  val input = path.fromResourcesReadLines()

  val grid = input
    .takeWhile { it != "" }
    .map { it.toCharArray() }
    .toTypedArray()

  val moves = input.drop(grid.size + 1)
    .flatMap {
      it
        .mapNotNull { char ->
          when(char) {
            '<' -> Direction.LEFT
            '^' -> Direction.UP
            '>' -> Direction.RIGHT
            'v' -> Direction.DOWN
            else -> null
          }
        }
    }

  return grid to moves
}
