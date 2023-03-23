    import java.util.*

    fun recoverFromPreorder(traversal: String): TreeNode? {
        val depthArray = getDepthArray(traversal)
        depthArray.forEach { println(it.contentToString()) }
        return getTree(depthArray)
    }

    private fun getDepthArray(traversal: String): ArrayList<Array<Int>> {
        val depthArray = ArrayList<Array<Int>>()
        var num = 0
        var depth = 0
        for (c in traversal) {
            if (c == '-') {
                if (num != 0) {
                    depthArray.add(arrayOf(num, depth))
                    num = 0
                    depth = 0
                }
                depth++
            } else {
                num = num * 10 + (c - '0')
            }
        }
        if (num != 0) {
            depthArray.add(arrayOf(num, depth))
        }
        return depthArray
    }

    private fun getTree(depthArray: ArrayList<Array<Int>>) : TreeNode? {
        if(depthArray.isEmpty()) return null
        val node = TreeNode(depthArray[0][0])
        val st = Stack<Pair<TreeNode, Int>>()
        st.add(Pair(node, depthArray[0][1]))
       for (i in 1 until depthArray.size) {
            val it = depthArray[i]
            if (st.peek().first.left != null && st.peek().first.right != null) st.pop()
            val nextNode = TreeNode(it[0])
            while (st.isNotEmpty() && st.peek().second >= it[1]) st.pop()
            if (st.peek().first.left == null) {
                st.peek().first.left = nextNode
            } else {
                st.peek().first.right = nextNode
            }
            st.add(Pair(nextNode, it[1]))
        }
        return node
    }

    fun main() {
        val traversal = "1-2--3--4-5--6--7"
        recoverFromPreorder(traversal)
    }