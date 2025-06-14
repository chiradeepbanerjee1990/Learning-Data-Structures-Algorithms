package Leetcode.Easy

class CountingBits {
        fun countBits(n: Int): IntArray {
            val result = IntArray(n + 1)
            for (i in 1..n) {
                result[i] = result[i / 2] + (i % 2)
            }
            return result
        }

}

fun main() {
    val n = 4
    val output = CountingBits().countBits(n)
    println(output.joinToString(", "))  // Output: 0, 1, 1, 2, 1
}