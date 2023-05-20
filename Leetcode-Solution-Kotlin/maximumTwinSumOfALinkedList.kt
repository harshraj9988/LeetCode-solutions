    fun pairSum(head: ListNode?): Int {
        if (head == null) return 0
        var a: ListNode? = head
        var b: ListNode? = head
        while (b != null) {
            b = b.next?.next
            if (b != null) {
                a = a!!.next
            }
        }

        var firstHalf = head
        val secondHalf = a!!.next
        a.next = null
        var reversedSecondHalf = reversedLinkedList(secondHalf)

        var maxSum = 0

        while (firstHalf != null || secondHalf != null) {
            maxSum = maxSum.coerceAtLeast(firstHalf!!.`val` + reversedSecondHalf!!.`val`)
            firstHalf = firstHalf.next
            reversedSecondHalf = reversedSecondHalf.next
        }

        return maxSum
    }

    private fun reversedLinkedList(a: ListNode?): ListNode? {
        if (a == null) return null
        var prev: ListNode? = null
        var curr = a
        var next = a.next

        while (curr != null) {
            curr.next = prev
            prev = curr
            curr = next
            next = next?.next
        }

        return prev
    }