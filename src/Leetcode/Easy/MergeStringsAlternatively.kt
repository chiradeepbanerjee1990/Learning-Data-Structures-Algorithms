package Leetcode.Easy

class MergeStringsAlternatively {

    fun mergeAlternately(word1: String, word2: String): String {
        val outputString : StringBuffer = StringBuffer()
        val lengthOne = word1.length;
        val lengthTwo = word2.length

        if(lengthOne == 0 && lengthTwo == 0)
            return outputString.toString()

        if(lengthOne == 0)
            return word2

        if(lengthTwo == 0)
            return word1

        val totalLength = lengthOne + lengthTwo
        val arrayListOne = word1.toCollection(ArrayList())
        val arrayListTwo = word2.toCollection(ArrayList())

        for(i in 0..totalLength-1 step 1){
            // Pick and Remove the first character from the respective list based on the index
           if(i % 2 == 0 && arrayListOne.isNotEmpty()) {
                outputString.append(arrayListOne[0])
                arrayListOne.removeAt(0)
            } else if (i % 2 != 0 && arrayListTwo.isNotEmpty()) {
                outputString.append(arrayListTwo[0])
                arrayListTwo.removeAt(0)
            }

        }

        if(arrayListOne.isNotEmpty()) {
            outputString.append(arrayListOne.joinToString(""))
        }

        if(arrayListTwo.isNotEmpty()) {
            outputString.append(arrayListTwo.joinToString(""))
        }

         // Convert StringBuffer to String and return
        return outputString.toString()
    }
}

fun main() {
    val result = MergeStringsAlternatively().mergeAlternately("ab", "pqr")
    println(result)  // Output: "apbqcr"
}
