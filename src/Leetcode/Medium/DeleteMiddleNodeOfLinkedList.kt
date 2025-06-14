package Leetcode.Medium

class DeleteMiddleNodeOfLinkedList {

    class Solution {
        fun deleteMiddle(head: ListNode?): ListNode? {
            // Find length of the linked list
            var length = 0
            var tempHead = head
            var currentNode = head
            var prevNode : ListNode? = null

            // Race Condition: If the head is null or has only one node, return null or the head respectively
            if(tempHead == null){
                return null
            }

            // Race Condition: If the head has only one node, return null
            if(tempHead.next == null){
                return null
            }

            // Calculate the length of the linked list
            while(tempHead != null){
                length++
                tempHead = tempHead.next
            }

            val middleIndex = length / 2


            // Step 2: Traverse to the node before middle
            for(i in 0..middleIndex) {
                if (i == middleIndex) {
                    prevNode?.next = currentNode?.next
                } else {
                    prevNode = currentNode
                    currentNode = currentNode?.next
                }
            }
            return head
        }
    }
}

fun main() {
    // Example usage
    val head = ListNode(1)
    head.next = ListNode(3)
    head.next?.next = ListNode(4)
    head.next?.next?.next = ListNode(7)
    head.next?.next?.next?.next = ListNode(1)
    head.next?.next?.next?.next?.next = ListNode(2)
    head.next?.next?.next?.next?.next?.next = ListNode(6)

    val solution = DeleteMiddleNodeOfLinkedList.Solution()
    val newHead = solution.deleteMiddle(head)

    // Print the modified list
    var current: ListNode? = newHead
    while (current != null) {
        print("${current.value} ")
        current = current.next
    }
}

class ListNode(var value: Int) {
    var next: ListNode? = null
}