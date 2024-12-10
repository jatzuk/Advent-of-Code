package dev.jatzuk.aoc.y2024.day09

class D9P1 {

  fun solution(input: List<Char>): Long {
    val memory = IntArray(input.sumOf { it.digitToInt() }) { -1 }
    var memoryIndex = 0

    val freeSpaceRanges = ArrayDeque<Pair<Int, Int>>()

    for ((blockId, i) in (input.indices step 2).withIndex()) {
      val blockSize = input[i].digitToInt()
      val spaceSize = input.getOrNull(i + 1)?.digitToInt()

      repeat(blockSize) {
        memory[memoryIndex++] = blockId
      }

      if (spaceSize != null && spaceSize != 0) {
        val start = memoryIndex
        memoryIndex += spaceSize
        freeSpaceRanges.add(start to start + spaceSize)
      }
    }

    memory.deFragment(freeSpaceRanges)

    return memory
      .withIndex()
      .sumOf { (index, value) ->
        if (value > 0) index * value.toLong() else 0L
      }
  }

  private fun IntArray.deFragment(freeSpaces: ArrayDeque<Pair<Int, Int>>) {
    var endIndex = this.lastIndex

    while (freeSpaces.isNotEmpty()) {
      val (start, end) = freeSpaces.removeFirst()
      if (start >= endIndex) {
        break
      }

      repeat(end - start) { offset ->
        val index = start + offset

        var latestValue: Int
        var endOffset = endIndex
        do {
          latestValue = this[endOffset--]
        } while (latestValue == -1)

        this[index] = latestValue

        repeat(endIndex - endOffset) { endDiffOffset ->
          this[endIndex - endDiffOffset] = -1
        }

        endIndex = endOffset
      }
    }
  }
}
