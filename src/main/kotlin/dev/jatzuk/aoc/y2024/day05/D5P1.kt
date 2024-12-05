package dev.jatzuk.aoc.y2024.day05

class D5P1 {

  fun solution(rules: List<Pair<Int, Int>>, updates: List<List<Int>>): Int {
    var acc = 0

    updates.forEach { update ->
      val isCorrect = update.isCorrect(rules)
      if (isCorrect) {
        acc += update[update.size / 2]
      }
    }

    return acc
  }

  private fun List<Int>.isCorrect(rules: List<Pair<Int, Int>>): Boolean {
    for (i in 0 until size - 1) {
      val before = this[i]
      val after = this[i + 1]

      val isCorrect = rules.any { rule ->
        before == rule.first && after == rule.second
      }

      if (!isCorrect) {
        return false
      }
    }

    return true
  }
}
