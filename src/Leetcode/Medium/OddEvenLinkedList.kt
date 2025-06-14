package Leetcode.Medium

class OddEvenLinkedList {

    fun oddEvenList(head: ListNode?): ListNode? {
        val oddArrayList = mutableListOf<Int>()
        val evenArrayList  = mutableListOf<Int>()

        var startNode = head
        var lengthFindNode = head
        var length = 0

        // The idea is each loop will run length / 2 times
        // Find length of the linked list
        while(lengthFindNode?.next != null){
            length++
            lengthFindNode = lengthFindNode.next
        }

        // If the length is 0 or 1, return the head as it is
        if(length == 0 || length == 1) {
            return head
        }

        for(i in 0..length){
            if(i % 2 == 0) {
                startNode?.value?.let { oddArrayList.add(it) }
                startNode = startNode?.next
            }else {
                startNode?.value?.let { evenArrayList.add(it) }
                startNode = startNode?.next
            }
        }
        // Now my odd and even list are ready

        val combined = oddArrayList + evenArrayList
        var resultHead: ListNode? = null
        var tail: ListNode? = null

        for (value in combined) {
            val newNode = ListNode(value)
            if (resultHead == null) {
                resultHead = newNode
                tail = newNode
            } else {
                tail?.next = newNode
                tail = newNode
            }
        }

        return resultHead
    }
}

fun main() {
    // Example usage
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(3)
    head.next?.next?.next = ListNode(4)
    head.next?.next?.next?.next = ListNode(5)

    val solution = OddEvenLinkedList()
    val newHead = solution.oddEvenList(head)

    // Print the modified list
    var current: ListNode? = newHead
    while (current != null) {
        print("${current.value} -> ")
        current = current.next
    }
    println("null")
}

