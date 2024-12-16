package dev.jatzuk.aoc.y2024.day13

class D13P1 {

  fun solution(input: List<ClawMachine>, pressLimit: Int): Long {
    return input.fold(0) { acc, machine ->
      val price = machine.find(pressLimit)
      if (price != -1) acc + price else acc
    }
  }

  private fun ClawMachine.find(pressLimit: Int): Int {
    repeat(pressLimit) { i ->
      repeat(pressLimit) { j ->
        val aPresses = i + 1
        val bPresses = j + 1

        val adx = aPresses * buttonA.x
        val ady = aPresses * buttonA.y

        val bdx = bPresses * buttonB.x
        val bdy = bPresses * buttonB.y

        val rx = (adx + bdx).toInt()
        val ry = (ady + bdy).toInt()
        if (rx == prize.x && ry == prize.y) {
          return (aPresses * 3) + bPresses
        }
      }
    }

    return -1
  }
}
