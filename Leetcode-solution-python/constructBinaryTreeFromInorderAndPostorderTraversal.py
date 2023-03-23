from typing import List, Optional

from TreeNode import TreeNode


class Solution:
    def build(self, io: List[int], po: List[int], mn: dict, s: int, e: int, i: int) -> Optional[TreeNode]:
        if s > e:
            return None
        if s == e:
            return TreeNode(io[s])

        node = TreeNode(po[i])
        pivot = mn[po[i]]
        node.right = self.build(io, po, mn, pivot + 1, e, i - 1)
        node.left = self.build(io, po, mn, s, pivot - 1, i - 1 - (e - pivot))
        return node

    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        n = len(inorder)
        if n == 1:
            return TreeNode(inorder[0])

        map_nodes = dict()

        for i in range(n):
            map_nodes[inorder[i]] = i

        return self.build(inorder, postorder, map_nodes, 0, n - 1, n - 1)
