package Leetcode.Easy

import java.util.Stack

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */

/**
 * Why it's important:
 *
 * Tests stack data structure basics.
 *
 * Interviewers love it because it shows how you handle simple but nested structures.
 */

class ValidParentheses {

    fun checkValidParenthesis(s: String): Boolean {
        val openSet = setOf('(', '[', '{')
        val closeSet = setOf(')', ']', '}')

        val stack = Stack<Char>()

        for (char in s) {
            if (char in openSet) {
                stack.push(char)
            } else if (char in closeSet) {
                if (stack.isEmpty()) return false
                val top = stack.pop()
                if ((char == ')' && top != '(') ||
                    (char == ']' && top != '[') ||
                    (char == '}' && top != '{')) {
                    return false
                }
            }
        }

        return stack.isEmpty()
    }


    fun main(){
        val obj = ValidParentheses()
        val givenInvalidString = "()({]"
        val givenValidString = "()()[]"
        obj.checkValidParenthesis(givenInvalidString)
    }
}