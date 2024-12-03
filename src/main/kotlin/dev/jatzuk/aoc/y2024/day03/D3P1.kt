package dev.jatzuk.aoc.y2024.day03

class D3P1 {

  fun solution(input: String): Long {
    val operations = """mul\(\d+,\d+\)""".toRegex().findAll(input)
    return operations
      .map { it.value }
      .map { operation ->
        val index = operation.indexOfFirst { char -> char == '(' }
        val operands = operation.substring(index + 1, operation.lastIndex)
        val (a, b) = operands.split(",").map(String::toLong)
        a to b
      }
      .sumOf { it.first * it.second }
  }
}
