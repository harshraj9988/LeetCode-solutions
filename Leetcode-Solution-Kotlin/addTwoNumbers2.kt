    import java.util.*

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var later: ListNode? = null
        var carry = 0
        val s1 = Stack<Int>()
        val s2 = Stack<Int>()
        var t1 = l1
        var t2 = l2
        while (t1 != null) {
            s1.add(t1.`val`)
            t1 = t1!!.next
        }
        while (t2 != null) {
            s2.add(t2.`val`)
            t2 = t2!!.next
        }

        while (s1.isNotEmpty() && s2.isNotEmpty()) {
            carry += s1.pop() + s2.pop()
            val node = ListNode(carry % 10)
            carry /= 10
            node.next = later
            later = node
        }
        while (s1.isNotEmpty()) {
            carry += s1.pop()
            val node = ListNode(carry % 10)
            carry /= 10
            node.next = later
            later = node
        }
        while (s2.isNotEmpty()) {
            carry += s2.pop()
            val node = ListNode(carry % 10)
            carry /= 10
            node.next = later
            later = node
        }
        while (carry > 0) {
            val node = ListNode(carry % 10)
            carry /= 10
            node.next = later
            later = node
        }

        return later
    }