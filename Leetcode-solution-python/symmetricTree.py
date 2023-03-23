from typing import Optional

from TreeNode import TreeNode


class Solution:
    def check(self, left: Optional[TreeNode], right: Optional[TreeNode]) -> bool:
        if not left and not right:
            return True
        if (not left and right) or (left and not right) or (left.val != right.val):
            return False
        return self.check(left.right, right.left) and self.check(left.left, right.right)

    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.check(root.left, root.right)
