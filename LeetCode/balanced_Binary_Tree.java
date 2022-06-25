/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as:
 * 
 * a binary tree in which the left and right subtrees of every node differ in
 * height by no more than 1.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 * Example 2:
 * 
 * 
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 * Example 3:
 * 
 * Input: root = []
 * Output: true
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 5000].
 * -104 <= Node.val <= 104
 */
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

public class balanced_Binary_Tree {
    private boolean check;

    private int solve(TreeNode root) {
        if (root == null || !check)
            return 0;
        int leftDepth = solve(root.left);
        int rightDepth = solve(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1)
            check = false;
        return (1 + Math.max(leftDepth, rightDepth));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        check = true;
        solve(root);
        return check;
    }
}
