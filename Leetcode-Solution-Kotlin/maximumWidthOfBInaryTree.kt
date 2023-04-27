    import java.util.LinkedList
    import java.util.Queue

    data class NodeAndPos(
        val treeNode: TreeNode,
        val pos: Int
    )

    fun widthOfBinaryTree(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val queue: Queue<NodeAndPos> = LinkedList()
        queue.offer(NodeAndPos(root, 0))
        var maxWidth = 0
        while (queue.isNotEmpty()) {
            val size = queue.size
            val minPos = queue.peek().pos
            var first = 0
            var last = 0
            repeat(size) {
                val currPos = queue.peek().pos - minPos
                val node = queue.poll().treeNode
                if (it == 0) first = currPos
                if (it == size - 1) last = currPos
                if (node.left != null) {
                    queue.offer(NodeAndPos(node.left!!, currPos * 2 + 1))
                }
                if (node.right != null) {
                    queue.offer(NodeAndPos(node.right!!, currPos * 2 + 2))
                }
            }
            maxWidth = maxWidth.coerceAtLeast(last - first + 1)
        }
        return maxWidth
    }