package dev.jatzuk.aoc.y2024.day08

import dev.jatzuk.aoc.util.Vector2D

class D8P1 {

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
                val distance = (second - first) * 2
                val target = first + distance

                if (target.x.toInt() in input[0].indices && target.y.toInt() in input.indices) {
                  acc.add(target)
                }
              }
          }
      }

    return acc.size
  }
}
