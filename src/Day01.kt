fun main() {
    fun part1(input: List<Int>): Int {
        return input.windowed(2).count { (a,b) -> a < b}
    }

    fun part2(input: List<Int>): Int {
        return input
            .windowed(3)
            .windowed(2)
            .count { (a,b) -> a.sum() < b.sum()}
    }

    //Better solution:  A + B + C <=> B + C + D   is equivalent to comparing A <=> D
    fun part2better(input: List<Int>): Int {
        return input
            .windowed(4)
            .count { it[0] < it[3]}
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputAsInts("Day01_test")
    check(part1(testInput) == 7)
    check(part2better(testInput) == 5)

    val input = readInputAsInts("Day01")
    println(part1(input))
    println(part2better(input))
}
