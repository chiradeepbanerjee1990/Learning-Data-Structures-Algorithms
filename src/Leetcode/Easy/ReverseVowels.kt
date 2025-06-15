package Leetcode.Easy

class ReverseVowels {

    fun reverseVowels(s: String): String {
        val vowelString = "aeiouAEIOU"

        // Two pointers approach
        var start = 0
        var end = s.length - 1

        val listOfString = s.toMutableList()

        while (start < end) {
            if (listOfString[start] in vowelString && listOfString[end] in vowelString) {
                // Swap the vowels
                val temp = listOfString[start]
                listOfString[start] = listOfString[end]
                listOfString[end] = temp
                start++
                end--
            } else if (listOfString[start] !in vowelString) {
                start++
            } else if (listOfString[end] !in vowelString) {
                end--
            }
        }

        return listOfString.joinToString("")
    }
}

fun main() {
    val reverseVowels = ReverseVowels()
    println(reverseVowels.reverseVowels("leetcode")) // Output: "leotcede"
    println(reverseVowels.reverseVowels("hello")) // Output: "holle"
    println(reverseVowels.reverseVowels("leetcode")) // Output: "leotcede"
    println(reverseVowels.reverseVowels("aA")) // Output: "Aa"
    println(reverseVowels.reverseVowels("AeIoU")) // Output: "UoIeA"
}