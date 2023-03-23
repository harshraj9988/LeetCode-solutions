# https://leetcode.com/problems/merge-k-sorted-lists/

from typing import Optional, List
from ListNode import ListNode
from heapq import heappush, heappop


class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        heap, ans = [], ListNode(-1)
        for i, temp in enumerate(lists):
            if temp:
                heappush(heap, (temp.val, i, temp))
        new_head = ans
        while heap:
            temp = heappop(heap)
            ans.next = temp[2]
            if temp[2].next:
                heappush(heap, (temp[2].next.val, temp[1], temp[2].next))
            ans = ans.next
            ans.next = None

        return new_head.next
