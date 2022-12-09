
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
    public int maxAncestorDiff(TreeNode root) {
        int ans = Math.max(
                dfs(root.left, root.val, root.val, 0),
                dfs(root.right, root.val, root.val, 0));
        return ans;
    }

    private int dfs(TreeNode node, int mini, int maxi, int diff) {
        if (node == null)
            return diff;
        int nMini = Math.min(mini, node.val);
        int nMaxi = Math.max(maxi, node.val);
        int nDiff = Math.max(diff, Math.abs(nMaxi - nMini));
        int left = dfs(node.left, nMini, nMaxi, nDiff);
        int right = dfs(node.right, nMini, nMaxi, nDiff);
        return Math.max(left, right);
    }
}