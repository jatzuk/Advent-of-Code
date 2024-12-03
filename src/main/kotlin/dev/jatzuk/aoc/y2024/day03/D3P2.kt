package dev.jatzuk.aoc.y2024.day03

class D3P2 {

  fun solution(input: String): Long {
    return """(mul\(\d+,\d+\))|(do(n't)?)\(\)""".toRegex().findAll(input)
      .map { it.value }
      .fold(0L to true) { acc, operation ->
        when (operation) {
          "do()" -> {
            acc.first to true
          }

          "don't()" -> {
            acc.first to false
          }

          else -> {
            val (sum, isEnabled) = acc
            if (!isEnabled) {
              acc
            } else {
              val (a, b) = operation
                .removeSurrounding("mul(", ")")
                .split(",")
                .map(String::toInt)
              sum + a * b to true
            }
          }
        }
      }
      .first
  }
}
