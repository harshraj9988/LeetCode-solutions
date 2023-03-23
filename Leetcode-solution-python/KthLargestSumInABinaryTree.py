from typing import Optional
from collections import deque

from TreeNode import TreeNode


def kthLargestLevelSum(self, root: Optional[TreeNode], k: int) -> int:
    q = deque()
    levels = list()
    q.append(root)
    while len(q) > 0:
        n = len(q)
        temp = 0
        for i in range(0, n):
            node = q.popleft()
            temp += node.val
            if node.left:
                q.append(node.left)
            if node.right:
                q.append(node.right)
        levels.append(temp)

    if len(levels) < k:
        return -1
    levels.sort()
    return levels[-k]
