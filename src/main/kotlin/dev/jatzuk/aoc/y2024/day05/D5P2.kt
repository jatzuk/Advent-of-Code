package dev.jatzuk.aoc.y2024.day05

class D5P2 {

  fun solution(rules: List<Pair<Int, Int>>, updates: List<List<Int>>): Int {
    val incorrect = updates.filterNot {
      it.isCorrect(rules)
    }

    return incorrect.fold(0) { acc, line ->
      val sorted = line.sortedWith { a, b -> if (a to b in rules) -1 else 1 }
      acc + sorted[sorted.size / 2]
    }
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
