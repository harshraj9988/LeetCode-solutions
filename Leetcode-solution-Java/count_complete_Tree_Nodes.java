
/**
Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.

 

Example 1:


Input: root = [1,2,3,4,5,6]
Output: 6
Example 2:

Input: root = []
Output: 0
Example 3:

Input: root = [1]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [0, 5 * 104].
0 <= Node.val <= 5 * 104
The tree is guaranteed to be complete.
*/

import java.util.*;
import java.io.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    int lastNodes = 0;
    boolean con = false;

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        TreeNode node = root;
        int height = 0;
        while (node != null) {
            node = node.left;
            height++;
        }
        lastNodes = dfs(root, height);
        lastNodes /= 2;
        return nodes(height, lastNodes);
    }

    private int dfs(TreeNode node, int height) {
        if (con)
            return 0;
        if (node == null) {
            if (height == 0)
                return 1;
            else
                con = true;
            return 0;
        }
        int x = dfs(node.left, height - 1);
        int y = dfs(node.right, height - 1);
        return x + y;
    }

    private int nodes(int height, int lastNodes) {
        int count = 0;
        height--;
        for (int i = 0; i < height; i++) {
            count += Math.pow(2, i);
        }
        return count + lastNodes;
    }
}