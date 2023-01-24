package exercicios

import kotlin.math.abs

class TreeNode() {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class BalancedBinaryTree {
    fun isBalanced(root: TreeNode?): Boolean {
        return if (root == null)
            true
        else {
            val left = findDepth(root.left)
            val right = findDepth(root.right)
            println(left)
            println(right)
            (abs(left - right) <= 1) && isBalanced(root.left) && isBalanced(root.right)
        }
    }

    fun findDepth(node: TreeNode?): Int {
        if (node == null)
            return 0
        return 1 + findDepth(node.right).coerceAtLeast(findDepth(node.left))
    }
}