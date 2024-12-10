package dev.jatzuk.aoc.y2024.day09

import java.util.TreeMap

class D9P2 {

  fun solution(input: List<Char>): Long {
    val freeSpaceRanges = mutableListOf<Page>()
    val files = TreeMap<Int, Page> { a, b -> b - a }

    var memoryIndex = 0
    for ((index, value) in input.withIndex()) {
      val size = value.digitToInt()
      if (index % 2 == 0) {
        val fileId = index / 2
        files[fileId] = Page(memoryIndex, size)
      } else {
        freeSpaceRanges.add(Page(memoryIndex, size))
      }
      memoryIndex += size
    }

    files.deFragment(freeSpaceRanges)

    return files.entries
      .sumOf { (fileId, page) ->
        (page.index until page.index + page.size).sumOf {
          it * fileId.toLong()
        }
    }
  }

  private fun MutableMap<Int, Page>.deFragment(freeSpaceRanges: MutableList<Page>) {
    for (fileId in keys) {
      val file = this[fileId] ?: continue

      var i = 0
      while (i < freeSpaceRanges.size) {
        val freeSpace = freeSpaceRanges[i]
        if (freeSpace.index > file.index) {
          break
        }

        val available = freeSpace.size - file.size

        if (available >= 0) {
          this[fileId] = Page(freeSpace.index, file.size)
          if (available == 0) {
            freeSpaceRanges.removeAt(i)
          } else {
            freeSpaceRanges[i] = Page(freeSpace.index + file.size, available)
          }
          break
        }

        i++
      }
    }
  }

  private class Page(val index: Int, val size: Int)
}
