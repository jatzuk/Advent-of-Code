package dev.jatzuk.aoc.y2024.day07

class D7P2 {

  fun solution(input: List<String>): Long {
    return input.sumOf {
      val target = it.substringBefore(":").toLong()
      val operands = it.substringAfter(" ")
        .split(" ")
        .map(String::toLong)

      val isSolvable = isSolvable(target, operands, 0, operands[0])
      if (isSolvable) target else 0L
    }
  }

  private fun isSolvable(target: Long, operands: List<Long>, index: Int, current: Long): Boolean {
    if (index == operands.lastIndex) {
      return current == target
    }

    val next = operands[index + 1]

    val addition = isSolvable(target, operands, index + 1, current + next)
    val multiplication = isSolvable(target, operands, index + 1, current * next)
    val concatenation = isSolvable(target, operands, index + 1, "$current$next".toLong())
    return addition || multiplication || concatenation
  }
}
