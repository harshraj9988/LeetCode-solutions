
// Given the root of a binary tree, return the inorder traversal of its nodes' values.

// Example 1:

//             1
//              \
//               \
//                2
//               /
//              /
//             3  

// Input: root = [1,null,2,3]
// Output: [1,3,2]
// Example 2:

// Input: root = []
// Output: []
// Example 3:

// Input: root = [1]
// Output: [1]

// Constraints:

// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100

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

public class binary_Tree_InOrder_Traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> finalList = new LinkedList<Integer>();

        if (root == null)
            return finalList;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode trav = root;

        stack.push(trav);
        while (!stack.isEmpty()) {
            
            if (trav.left != null) {
                trav = trav.left;
                stack.push(trav);
                continue;
            }
            trav = stack.pop();
            trav.left = null;
            finalList.add(trav.val);

            if(trav.right != null){
                stack.push(trav.right);
                trav = trav.right;
            }

        }

        return finalList;
    }
}
