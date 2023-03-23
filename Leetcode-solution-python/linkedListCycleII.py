from typing import Optional

from ListNode import ListNode


class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return None

        slow, fast = head.next, head.next.next

        while fast and fast.next and slow is not fast:
            slow = slow.next
            fast = fast.next.next

        if not fast or not fast.next:
            return None

        slow = head
        while slow is not fast:
            slow = slow.next
            fast = fast.next

        return slow
