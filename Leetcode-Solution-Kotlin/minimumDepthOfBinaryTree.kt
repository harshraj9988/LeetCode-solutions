    fun minDepth(root: TreeNode?): Int {
        if(root == null) return 0
        return dfs(root)
    }

    private fun dfs(node: TreeNode): Int {
        if(node.left == null && node.right == null) return 1
        var nDepth = Int.MAX_VALUE
        if(node.left != null) nDepth = nDepth.coerceAtMost(dfs(node.left!!))
        if(node.right != null) nDepth = nDepth.coerceAtMost(dfs(node.right!!))
        return 1+nDepth
    }