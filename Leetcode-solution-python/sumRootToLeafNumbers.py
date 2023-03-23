from typing import Optional, List

from TreeNode import TreeNode


class Solution:
    path_sum = 0

    def calc(self, node: TreeNode, num: int):
        new_num = num * 10 + node.val

        if not node.left and not node.right:
            self.path_sum += new_num

        if node.left:
            self.calc(node.left, new_num)
        if node.right:
            self.calc(node.right, new_num)

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        arr = list()
        self.calc(root, 0, arr)
        return self.path_sum
