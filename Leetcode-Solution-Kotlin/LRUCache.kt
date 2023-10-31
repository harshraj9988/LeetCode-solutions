class LRUCache(capacity: Int) {

    data class Node(
        val key: Int,
        var value: Int,
        var prev: Node? = null,
        var next: Node? = null
    )

    private fun add(node: Node) {
        val temp = tail.prev
        node.next = tail
        node.prev = temp

        tail.prev = node
        temp?.next = node
    }

    private fun delete(node: Node) {
        val prev = node.prev
        val next = node.next

        prev?.next = next
        next?.prev = prev
    }

    val size = capacity
    val map = HashMap<Int, Node>()
    var head = Node(-1, -1)
    var tail = Node(-1, -1)

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        if(key in map) {
            val node = map[key]!!
            map.remove(key)
            delete(node)
            add(node)
            map[key] = tail.prev!!

            return node.value
        }
        return -1
    }

    fun put(key: Int, value: Int) {
        if(key in map) {
            val curr = map[key]!!
            map.remove(key)
            delete(curr)
        }

        if(map.size == size) {
            map.remove(head.next!!.key)
            delete(head.next!!)
        }

        add(Node(key, value))
        map[key] = tail.prev!!
    }
}