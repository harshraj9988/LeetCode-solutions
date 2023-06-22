    import java.util.LinkedList
    import java.util.Queue

    fun maxLevelSum(root: TreeNode?): Int {
        if (root == null) return 0

        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        var level = 1
        var maximumSum = Int.MIN_VALUE
        var minimumLevel = level
        while (queue.isNotEmpty()) {
            val size = queue.size
            var sum = 0
            repeat(size) {
                val node = queue.poll()
                sum += node.`val`
                if (node.left != null) queue.offer(node.left)
                if (node.right != null) queue.offer(node.right)
            }
            if (sum > maximumSum) {
                maximumSum = sum
                minimumLevel = level
            }
            level++
        }
        return minimumLevel
    }