package Leetcode.Medium

class ReverseWords {

    fun reverseWords(s: String): String {
        val outputString = s.trim() // Removed front and backspaces
        val listOfString = outputString.split(" ")
        val reverseList = mutableListOf<String>()

        for(i in listOfString.size -1 downTo 0) {
            if (!listOfString[i].isEmpty() || !listOfString[i].isBlank()) {
                reverseList.add(listOfString[i])
            }
        }
        return reverseList.joinToString(" ")
    }
}

fun main() {
    val reverseWords = ReverseWords()
    println(reverseWords.reverseWords("the sky is blue")) // Output: "blue is sky the"
    println(reverseWords.reverseWords("  hello world  ")) // Output: "world hello"
    println(reverseWords.reverseWords("a good   example")) // Output: "example good a"
    println(reverseWords.reverseWords("  Bob    Loves  Alice   ")) // Output: "Alice Loves Bob"
    println(reverseWords.reverseWords("Alice does not even like bob")) // Output: "bob like even not does Alice"
}