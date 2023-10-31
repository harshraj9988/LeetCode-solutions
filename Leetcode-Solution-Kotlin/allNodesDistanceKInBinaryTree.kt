    import java.util.LinkedList
    import java.util.Queue

    private val adj = HashMap<Int, ArrayList<Int>>()
    fun distanceK(root: TreeNode?, target: TreeNode?, k: Int): List<Int> {
        if(root == null || target == null) return emptyList()
        createGraph(root)
        val ans = ArrayList<Int>()
        val vis = HashSet<Int>()
        vis.add(target!!.`val`)
        val q: Queue<Int> = LinkedList()
        q.add(target!!.`val`)
        var dist = 0

        while (q.isNotEmpty()) {
            val node = q.poll()
            dist++
            if(dist > k) break
            if(node in adj) {
                for(next in adj[node]!!) {
                    if(next in vis) continue
                    vis.add(next)
                    if(dist == k) ans.add(next)
                }
            }
        }

        return ans
    }

    private fun createGraph(node: TreeNode?) {
        if(node == null) return
        val list = adj[node.`val`] ?: ArrayList()
        if(node.left != null) {
            val lList  = adj[node.left!!.`val`] ?: ArrayList()
            lList.add(node.`val`)
            list.add(node.left!!.`val`)
            adj[node.left!!.`val`] = lList
            createGraph(node.left)
        }
        if(node.right != null) {
            val rList = adj[node.right!!.`val`] ?: ArrayList()
            rList.add(node.`val`)
            list.add(node.right!!.`val`)
            adj[node.right!!.`val`] = rList
            createGraph(node.right)
        }
        adj[node.`val`] = list
    }
