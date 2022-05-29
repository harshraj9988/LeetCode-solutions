
// Given the root of a binary tree, return the preorder traversal of its nodes' values.

// Example 1:

//             1
//              \
//               \
//                2
//               /
//              /
//             3  

// Input: root = [1,null,2,3]
// Output: [1,2,3]
// Example 2:

// Input: root = []
// Output: []
// Example 3:

// Input: root = [1]
// Output: [1]

// Constraints:

// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100

import java.util.*;;

class TreeNode {
    int val;
    treeNode left;
    treeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, treeNode left, treeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class binary_Tree_PreOrder_Traversal {
    public List<Integer> preorderTraversal(treeNode root) {
        List<Integer> finalList = new LinkedList<Integer>();

        if (root == null)
            return finalList;

        Stack<treeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            finalList.add(root.val);

            if (root.right != null)
                stack.push(root.right);
            if (root.left != null)
                stack.push(root.left);
        }
        return finalList;
    }
}
