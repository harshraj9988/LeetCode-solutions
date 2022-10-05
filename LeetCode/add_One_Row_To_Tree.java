
/**

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

    private void dfs(TreeNode node, int val, int depth) {
        if (depth == 1 && node != null) {
            TreeNode l = node.left, r = node.right;
            TreeNode newNodeLeft = new TreeNode(val), newNodeRight = new TreeNode(val);
            newNodeLeft.left = l;
            newNodeRight.right = r;
            node.left = newNodeLeft;
            node.right = newNodeRight;
            return;
        }
        if (node.left != null)
            dfs(node.left, val, depth - 1);
        if (node.right != null)
            dfs(node.right, val, depth - 1);
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        dfs(root, val, depth-1);
        return root;
    }
}