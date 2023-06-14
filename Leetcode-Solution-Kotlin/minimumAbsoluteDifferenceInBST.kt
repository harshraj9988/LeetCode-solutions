    fun getMinimumDifference(root: TreeNode?): Int {
        val list = ArrayList<Int>()
        getNodeValues(root, list)
        list.sort()
        var ans = Int.MAX_VALUE
        for (i in 0 until list.lastIndex) {
            ans = ans.coerceAtMost(list[i + 1] - list[i])
        }
        return ans
    }

    private fun getNodeValues(root: TreeNode?, list: ArrayList<Int>) {
        if (root == null) return
        list.add(root.`val`)
        getNodeValues(root.left, list)
        getNodeValues(root.right, list)
    }