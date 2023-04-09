class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList<Node?>()
}

    private fun solve(node: Node, newNode: Node, nodes: HashMap<Int, Node>, vis: HashSet<Int>) {
        if (vis.contains(node.`val`)) {
            return
        }

        print("${node} ${newNode}")

        vis.add(node.`val`)

        for(next in node.neighbors){
            if(next == null){
                newNode.neighbors.add(null)
            }else{
                if(!nodes.contains(next.`val`)){
                    nodes[next.`val`] = Node(next.`val`)
                }
                newNode.neighbors.add(nodes[next.`val`])
            }
        }

        for(i in node.neighbors.indices) {
            if(node.neighbors[i] != null) {
                solve(node.neighbors[i]!!, newNode.neighbors[i]!!, nodes, vis)
            }
        }
    }

    fun cloneGraph(node: Node?): Node? {
        if (node == null) {
            return null
        }
        val nodes = HashMap<Int, Node>()
        val vis = HashSet<Int>()

        val newNode = Node(node.`val`)
        solve(node, newNode, nodes, vis)
        return newNode
    }