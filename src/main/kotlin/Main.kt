package learning.gradle

fun main() {

    println("How many rings would you like")
    val rings = readln().toInt()
    val hanoiTower = HanoiTower(rings)
    var from: Int
    var to: Int

    do {
        hanoiTower.printTower()
        print("From: ")
        from = readln().toInt()
        print("To: ")
        to = readln().toInt()
        try {
            hanoiTower.moveRing(from, to)
        } catch (e: Exception) {
            println(e.message)
        }

    }   while (!hanoiTower.isFinished())

    println("CONGRATS YOU WON!")
}