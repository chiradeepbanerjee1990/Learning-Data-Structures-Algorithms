package Leetcode.Medium

class LeafSimilarTree {

    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        var listOne = mutableListOf<Int>()
        var listThree = mutableListOf<Int>()


        if(root1 == null && root2 == null) return false

        if(root1 != null && root2 == null) return false

        if(root1 == null) return false


        if(root1.left == null && root1.right == null && root2?.left == null && root2?.right == null && root1.value != root2?.value) {
            return false
        }

        listOne = onlyPrintLeaf(root1, listOne)

        val listNewOne = listOne

        listThree = onlyPrintLeaf(root2, listThree)

        val listNewTwo = listThree

        return listNewOne == listNewTwo



    }

    fun onlyPrintLeaf(root: TreeNode?, list: MutableList<Int>) : MutableList<Int>{
        if(root == null) return list
        val headNode = root
        if(root.left == null && root.right == null) {
            list.add(root.value!!)
        }
        if(headNode.left != null)
        onlyPrintLeaf(headNode.left, list)

        if(headNode.right != null)
        onlyPrintLeaf(headNode.right, list)

        return list
    }


}

fun main() {
    // Example usage
    val root1 = TreeNode(3)
    root1.left = TreeNode(5)
    root1.right = TreeNode(1)
    root1.right?.left = TreeNode(9)
    root1.right?.right = TreeNode(8)
    root1.left?.left = TreeNode(6)
    root1.left?.right = TreeNode(2)
    root1.left?.right?.left = TreeNode(7)
    root1.left?.right?.right = TreeNode(4)

    val root2 = TreeNode(4)
    root2.left = TreeNode(5)
    root2.right = TreeNode(1)
    root2.left?.left = TreeNode(6)
    root2.left?.right = TreeNode(7)
    root2.right?.left = TreeNode(4)

    val solution = LeafSimilarTree()
    println(solution.leafSimilar(root1, root2))  // Output: true or false based on leaf similarity
}

class TreeNode(var value: Int?) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
