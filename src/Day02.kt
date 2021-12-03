fun main() {
    fun part1(input: List<String>): Int {
        val forward = input.filter { it.lowercase().startsWith("forward") }
        val down = input.filter { it.lowercase().startsWith("down") }
        val up = input.filter { it.lowercase().startsWith("up") }

        var forwardSum = 0
        forward.iterator().forEach { forwardSum += it.substring(8).toInt()}

        var downSum = 0
        down.iterator().forEach { downSum += it.substring(5).toInt()}

        var upSum = 0
        up.iterator().forEach { upSum += it.substring(3).toInt()}

        return forwardSum * (downSum - upSum)
    }

    fun part2(input: List<String>): Int {
        var forwardSum = 0
        var aim = 0
        var depth = 0

        input.iterator().forEach {
            when {
                it.startsWith("f") -> {
                    val inc = it.substring(8).toInt()
                    forwardSum += inc
                    depth += aim * inc
                }
                it.startsWith("d") -> aim += it.substring(5).toInt()
                it.startsWith("u") -> aim -= it.substring(3).toInt()
            }
        }
        return forwardSum * depth
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
