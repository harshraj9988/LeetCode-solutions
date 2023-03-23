import java.util.ArrayList;

/**
 * Given the root of a binary tree, flatten the tree into a "linked list":
 * 
 * The "linked list" should use the same TreeNode class where the right child
 * pointer points to the next node in the list and the left child pointer is
 * always null.
 * The "linked list" should be in the same order as a pre-order traversal of the
 * binary tree.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,5,3,4,null,6]
 * Output: [1,null,2,null,3,null,4,null,5,null,6]
 * Example 2:
 * 
 * Input: root = []
 * Output: []
 * Example 3:
 * 
 * Input: root = [0]
 * Output: [0]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 2000].
 * -100 <= Node.val <= 100
 * 
 * 
 * Follow up: Can you flatten the tree in-place (with O(1) extra space)?
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

public class flatten_Binary_Tree_To_Linked_List {
    public void flatten(TreeNode root) {
        if(root == null) return;
        ArrayList<TreeNode> arr = new ArrayList<>();
        solve(root, arr);
        int n = arr.size();
        for (int i = 0; i < n-1; i++) {
           arr.get(i).right = arr.get(i+1);
        }
        root = arr.get(0);
    }

    private void solve(TreeNode node, ArrayList<TreeNode> arr) {
        if (node == null)
            return;
        TreeNode l = node.left;
        TreeNode r = node.right;
        node.left = null;
        node.right = null;
        arr.add(node);
        solve(l, arr);
        solve(r, arr);
    }
}