package Leetcode.Easy

class GCDOfString {

    fun gcdOfStrings(str1: String, str2: String): String {
        if (str1 + str2 != str2 + str1) {
            return ""
        }

        val gcdLength = gcd(str1.length, str2.length)
        return str1.substring(0, gcdLength)
    }

    private fun gcd(length: Int, length2: Int): Int {
        var a = length
        var b = length2
        if(a > b) {
            while (b != 0) {
                val temp = b
                b = a % b
                a = temp
            }
            return a
        }else {
            while (a != 0) {
                val temp = a
                a = b % a
                b = temp
            }
            return b
        }
    }


}

fun main() {
    val gcdOfString = GCDOfString()
    val result = gcdOfString.gcdOfStrings("ABCABC", "ABC")
    println(result)  // Output: "ABC"

    val result2 = gcdOfString.gcdOfStrings("ABABAB", "ABAB")
    println(result2)  // Output: "AB"

    val result3 = gcdOfString.gcdOfStrings("LEET", "CODE")
    println(result3)  // Output: ""
}