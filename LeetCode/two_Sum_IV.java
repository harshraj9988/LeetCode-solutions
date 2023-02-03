
/**
 * Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.

 

Example 1:


Input: root = [5,3,6,2,4,null,7], k = 9
Output: true
Example 2:


Input: root = [5,3,6,2,4,null,7], k = 28
Output: false
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-104 <= Node.val <= 104
root is guaranteed to be a valid binary search tree.
-105 <= k <= 105
 */
import java.util.*;

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

public class two_Sum_IV {
    private Set<Integer> set;
    private boolean check;

    public void solve(TreeNode root, int n) {
        if (root == null || check) {
            return;
        }
        if (set.contains(n - root.val)) {
            check = true;
            return;
        }
        set.add(root.val);
        solve(root.left, n);
        solve(root.right, n);

    }

    public boolean findTarget(TreeNode root, int n) {
        set = new HashSet<>();
        check = false;
        solve(root, n);
        return check;

    }
}
