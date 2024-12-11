package dev.jatzuk.aoc.y2024.day11

class D11P1 {

  fun solution(input: String, blinks: Int): Int {
    var stones = input
      .split("\\s".toRegex())
      .asSequence()
      .map { it.toLong() }
      .toList()

    repeat(blinks) {
      stones = transform(stones)
    }

    return stones.size
  }

  private fun transform(origin:List<Long>): List<Long> = buildList {
    origin.forEach { n ->
      val digitString = n.toString()

      when {
        n == 0L -> {
          add(1)
        }

        digitString.length % 2 == 0 -> {
          val left = digitString.substring(0, digitString.length / 2).toLong()
          val right = digitString.substring(digitString.length / 2).toLong()
          add(left)
          add(right)
        }

        else -> {
          add(n * 2024)
        }
      }
    }
  }
}
