package learning.gradle

import java.util.Stack

class HanoiTower(private val rings: Int) {

    // towers[0] leftmost tower
    // towers[1] rightmost tower
    private val towers = Array(3) { Stack<Int>() }

    init {
        for (i in rings downTo 1) {
            towers[0].push(i)
        }
    }

    @Throws(Exception::class)
    private fun Stack<Int>.addRing(ring: Int) {
        if (this.isEmpty()) {
            this.push(ring)
            return
        }

        if (this.peek() < ring) {
            throw Exception("Cannot put a larger ring on a smaller one")
        }

        this.push(ring)
    }

    @Throws(Exception::class)
    fun moveRing(from: Int, to: Int) {
        val valfrom = from - 1
        var valto = to - 1

        if (towers[valfrom].isEmpty()) {
            throw Exception("Cannot move from empty tower")
        }

        towers[valto].addRing(towers[valfrom].peek())

        towers[valfrom].pop()
    }

    fun isFinished(): Boolean {
        return towers[0].isEmpty() && towers[1].isEmpty()
    }

    fun printTower() {
        // Iterate through each row (ring position) from 1 to the maximum number of rings
        for (row in 1..rings) {
            // Iterate through each tower
            for ((index, tower) in towers.withIndex()) {
                // Check if the tower has a ring at the current position
                val ringSize = tower.size
                val ringIndex = rings - row // Adjust ring index to start from bottom
                if (ringIndex < ringSize) {
                    // Tower has a ring at the current position, print the width of the ring
                    val ringWidth = tower.elementAt(ringIndex) // Get the width of the ring at this position
                    print("$ringWidth")
                } else {
                    // Tower does not have a ring at the current position, print empty space with spacing
                    print("|")
                }
                if (index != towers.size - 1) {
                    print(" ".repeat(rings - 1))
                }
            }
            // Move to the next row
            println()
        }
        println("-".repeat(8))
        println("1" + " ".repeat(2) + "2" + " ".repeat(2) + "3")
    }
}
