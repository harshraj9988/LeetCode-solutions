class SplitLinkedListInParts {

    inner class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
    fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
        val length = getLengthOfLinkedList(head)
        val eachPart = length / k
        var extra = length % k
        var node : ListNode? = head
        var prev : ListNode? = null
        val ans: Array<ListNode?> = Array(k) { null }
        repeat(k) {
            val nHead = node
            repeat(eachPart) {
                prev = node
                node = node?.next
            }
            if(extra > 0) {
                prev = node
                node = node?.next
                extra--
            }
            prev?.next = null
            ans[it] = nHead
        }
        return ans
    }

    private fun getLengthOfLinkedList(head: ListNode?) : Int {
        if(head == null) return 0
        var length = 0
        var trav: ListNode? = head
        while(trav != null) {
            length++
            trav = trav.next
        }
        return length
    }
}