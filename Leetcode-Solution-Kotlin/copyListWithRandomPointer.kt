class CopyListWithRandomPointer {
    inner class Node(var `val`: Int) {
        var next: Node? = null
        var random: Node? = null
    }

    fun copyRandomList(node: Node?): Node? {
        if(node == null) return null
        val nodePool = HashMap<Int, Pair<Node, Node>>()
        var trav : Node? = node
        while(trav != null) {
            nodePool[trav.hashCode()] = Pair(trav, Node(trav.`val`))
            trav = trav.next
        }
        trav = node
        while(trav != null) {
            val old = nodePool[trav.hashCode()]!!.first
            val currNode = nodePool[trav.hashCode()]!!.second
            if(old.next != null) {
                currNode.next = nodePool[old.next!!.hashCode()]!!.second
            }
            if(old.random != null) {
                currNode.random = nodePool[old.random!!.hashCode()]!!.second
            }
            trav = trav.next
        }
        return nodePool[node.hashCode()]!!.second
    }
}