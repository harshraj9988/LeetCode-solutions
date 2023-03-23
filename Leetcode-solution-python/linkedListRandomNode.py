import random
from typing import Optional

from ListNode import ListNode


class Solution:
    def __init__(self, head: Optional[ListNode]):
        self.arr = list()
        while head:
            self.arr.append(head.val)
            head = head.next

    def getRandom(self) -> int:
        return self.arr[random.randint(0, len(self.arr)-1)]
