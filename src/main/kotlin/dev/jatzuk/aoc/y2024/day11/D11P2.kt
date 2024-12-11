package dev.jatzuk.aoc.y2024.day11

class D11P2 {

  fun solution(input: String, blinks: Int): Long {
    val stateCounts = input
      .split("\\s".toRegex())
      .map { it.toLong() }
      .associateWith { 1L }
      .toMutableMap()

    repeat(blinks) {
      val state = mutableMapOf<Long, Long>()

      for ((n, count) in stateCounts) {
        val digitString = n.toString()

        when {
          n == 0L -> {
            state[1] = state.getOrDefault(1, 0) + count
          }

          digitString.length % 2 == 0 -> {
            val left = digitString.substring(0, digitString.length / 2).toLong()
            val right = digitString.substring(digitString.length / 2).toLong()
            state[left] = state.getOrDefault(left, 0) + count
            state[right] = state.getOrDefault(right, 0) + count
          }

          else -> {
            val value = n * 2024L
            state[value] = state.getOrDefault(value, 0) + count
          }
        }
      }

      stateCounts.clear()
      stateCounts.putAll(state)
    }

    return stateCounts.values.sum()
  }
}
