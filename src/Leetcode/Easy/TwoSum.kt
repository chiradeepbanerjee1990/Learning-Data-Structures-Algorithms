package Leetcode.Easy

/**
 * Given an array of integers numbers and an integer target, return the indices of the two numbers such that they add up to target.
 */

/**
 * Why it's important:
 *
 * Checks basic array and hash map understanding.
 *
 * Tests problem-solving + thinking in O(n) time.
 *
 */

class TwoSum {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numMap = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            val remaining = target - nums[i]
            if (numMap.contains(remaining)) {
                return intArrayOf(numMap[remaining]!!, i)
            }
            numMap[nums[i]] = i
        }
        return intArrayOf()
    }
}

    fun main(){
        val array = intArrayOf(2,7,11,15)
        val target = 9
        val returnedArray = TwoSum().twoSum(array,target)
        for(i in returnedArray.indices)
            print("${returnedArray[i]}\t")
    }


