from typing import *
from ListNode import ListNode
from TreeNode import TreeNode


class Solution:
    def formTree(self, nodes: List[int], left: int, right: int) -> Optional[TreeNode]:
        if left > right:
            return None
        if left == right:
            return TreeNode(val=nodes[left])

        mid = left + (right - left) // 2
        left_subtree = self.formTree(nodes, left, mid - 1)
        right_subtree = self.formTree(nodes, mid + 1, right)
        return TreeNode(val=nodes[mid], left=left_subtree, right=right_subtree)

    def sortedListToBST(self, head: Optional[ListNode]) -> Optional[TreeNode]:
        nodes = list()
        while head:
            nodes.append(head.val)
            head = head.next
        return self.formTree(nodes, 0, len(nodes) - 1)
