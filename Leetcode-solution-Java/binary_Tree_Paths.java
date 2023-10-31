
/**
 * Given the root of a binary tree, return all root-to-leaf paths in any order.

A leaf is a node with no children.

 

Example 1:


Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]
Example 2:

Input: root = [1]
Output: ["1"]
 

Constraints:

The number of nodes in the tree is in the range [1, 100].
-100 <= Node.val <= 100
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

public class binary_Tree_Paths {
    private void pathToLeaf(TreeNode node, StringBuilder sb, List<String> finalList) {
        if (node == null) {
            return;
        }
        int size = sb.length();
        sb.append(node.val);
        if (node.left == null && node.right == null) {
            finalList.add(sb.toString());
            return;
        } else {
            sb.append("->");
            pathToLeaf(node.left, sb, finalList);
            pathToLeaf(node.right, sb, finalList);
            sb.setLength(size);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> finalList = new ArrayList<>();
        if (root == null)
            return finalList;
        pathToLeaf(root, new StringBuilder(), finalList);
        return finalList;
    }
}
