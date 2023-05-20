    fun swapPairs(head: ListNode?): ListNode? {
        if (head == null || head.next == null) return head

        val preHead = ListNode(0)
        preHead.next = head

        var a: ListNode? = preHead
        var b: ListNode? = head.next

        while (b != null) {
            val temp = a?.next
            a?.next = b
            temp?.next = b?.next
            b?.next = temp

            a = temp
            b = temp?.next?.next
        }

        return preHead.next
    }