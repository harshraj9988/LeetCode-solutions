from typing import Optional

from TreeNode import TreeNode
from collections import deque


class Solution:
    def isCompleteTree(self, root: Optional[TreeNode]) -> bool:
        dq = deque()
        dq.append(root)
        no_further = False
        while len(dq):
            n = len(dq)
            while n > 0:
                n -= 1
                node = dq.popleft()
                if no_further and (node.left or node.right):
                    return False

                if node.left:
                    dq.append(node.left)
                else:
                    no_further = True

                if node.right:
                    if no_further:
                        return False
                    dq.append(node.right)
                else:
                    no_further = True

        return True
