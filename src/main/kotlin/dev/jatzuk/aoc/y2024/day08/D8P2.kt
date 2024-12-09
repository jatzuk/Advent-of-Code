package dev.jatzuk.aoc.y2024.day08

import dev.jatzuk.aoc.y2024.util.Vector2D
import dev.jatzuk.aoc.y2024.util.isInside

class D8P2 {

  fun solution(input: List<String>): Int {
    val antennas = mutableMapOf<Char, MutableSet<Vector2D>>()

    for ((y, row) in input.withIndex()) {
      for ((x, c) in row.withIndex()) {
        if (c == '.') {
          continue
        }

        antennas.getOrPut(c) { mutableSetOf() }.add(Vector2D(x, y))
      }
    }

    val acc = hashSetOf<Vector2D>()

    antennas.keys
      .forEach { type ->
        antennas[type].orEmpty()
          .forEach { first ->
            antennas[type].orEmpty()
              .filterNot { it == first }
              .forEach { second ->
                val distance = second - first

                accumulate(
                  input,
                  first,
                  acc = { it + distance },
                  onInside = { acc.add(it) }
                )

                accumulate(
                  input,
                  first,
                  acc = { it - distance },
                  onInside = { acc.add(it) }
                )
              }
          }
      }

    return acc.size
  }

  private fun accumulate(
    input: List<String>,
    start: Vector2D,
    acc: (Vector2D) -> Vector2D,
    onInside: (Vector2D) -> Unit
  ) {
    var vector = start

    while (true) {
      vector = acc(vector)

      if (vector.isInside(input)) {
        onInside(vector)
      } else {
        break
      }
    }
  }
}
