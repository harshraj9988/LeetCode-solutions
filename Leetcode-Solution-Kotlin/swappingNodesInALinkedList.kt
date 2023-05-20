class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun swapNodes(head: ListNode?, k: Int): ListNode? {
    var trav = head
    var count = 1
    while (count < k) {
        trav = trav!!.next
        count++
    }
    val firstNode = trav
    var secondNode = head
    while (trav!!.next != null) {
        trav = trav!!.next
        secondNode = secondNode!!.next
    }
    val temp = firstNode!!.`val`
    firstNode.`val` = secondNode!!.`val`
    secondNode.`val` = temp
    return head
}
