/**
 * Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

 

Example 1:


Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:

Input: root = [1,2]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100
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
public class diameter_Of_Binary_Tree {
    private int diameter;
    
    public int solve(TreeNode node){
        if(node==null) return 0;
        
        int leftDepth = solve(node.left);
        int rightDepth = solve(node.right);
        
        diameter = Math.max(diameter, (leftDepth + rightDepth));
        
        return (1+Math.max(leftDepth, rightDepth));
        
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        solve(root);
        return diameter;
    }
}
