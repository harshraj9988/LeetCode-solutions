    // dir: 0 = left, 1 = right

    private var maxLen = 0
    private fun dfs(node: TreeNode?, leftDir: Boolean, len: Int) {
        if(node == null) {
            return
        }
        maxLen = maxLen.coerceAtLeast(len)
        if(leftDir) {
            dfs(node.left, false, len+1)
            dfs(node.right, true, 1)
        }else{
            dfs(node.right, true, len+1)
            dfs(node.left, false, 1)
        }

    }

    fun longestZigZag(root: TreeNode?): Int {
        if(root == null){
            return 0
        }
        dfs(root, true, 0)
        dfs(root, false, 0)

        return maxLen
    }

