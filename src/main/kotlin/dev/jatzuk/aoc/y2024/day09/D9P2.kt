package dev.jatzuk.aoc.y2024.day09

import java.util.TreeSet

class D9P2 {

  fun solution(input: List<Char>): Long {
    val memory = IntArray(input.sumOf { it.digitToInt() }) { -1 }
    var memoryIndex = 0

    val freeSpaceRanges = ArrayDeque<Pair<Int, Int>>()
    val files = TreeSet<Triple<Int, Int, Int>> { a, b -> b.first - a.first }

    for ((blockId, i) in (input.indices step 2).withIndex()) {
      val blockSize = input[i].digitToInt()
      val spaceSize = input.getOrNull(i + 1)?.digitToInt()

      files.add(Triple(blockId, blockSize, memoryIndex))

      repeat(blockSize) {
        memory[memoryIndex++] = blockId
      }

      if (spaceSize != null && spaceSize != 0) {
        val start = memoryIndex
        memoryIndex += spaceSize
        freeSpaceRanges.add(start to start + spaceSize)
      }
    }

    memory.deFragment(files, freeSpaceRanges)

    return memory
      .withIndex()
      .sumOf { (index, value) ->
        if (value > 0) index * value.toLong() else 0L
      }
  }

  private fun IntArray.deFragment(files: Set<Triple<Int, Int, Int>>, freeSpaceRanges: ArrayDeque<Pair<Int, Int>>) {
    for ((id, size, startIndex) in files) {
      val freeSpaceIndex = freeSpaceRanges.indexOfFirst { (start, end) -> end - start >= size }
      if (freeSpaceIndex == -1) {
        continue
      }

      val (start, end) = freeSpaceRanges[freeSpaceIndex]
      val available = end - start
      if (available < size) {
        continue
      }

      repeat(size) {
        this[start + it] = id
        this[startIndex + it] = -1
      }

      val endIndex = start + size
      if (endIndex == end) {
        freeSpaceRanges.removeAt(freeSpaceIndex)
      } else {
        freeSpaceRanges[freeSpaceIndex] = endIndex to end
      }
    }
  }
}
