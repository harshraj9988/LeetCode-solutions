// Given the root of a binary tree, return the postorder traversal of its nodes' values.

 

// Example 1:

//             1
//              \
//               \
//                2
//               /
//              /
//             3  

// Input: root = [1,null,2,3]
// Output: [3,2,1]
// Example 2:

// Input: root = []
// Output: []
// Example 3:

// Input: root = [1]
// Output: [1]
 

// Constraints:

// The number of the nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100

import java.util.*;

 class TreeNode_ {
     int val;
     TreeNode_ left;
     TreeNode_ right;
     TreeNode_() {}
     TreeNode_(int val) { this.val = val; }
     TreeNode_(int val, TreeNode_ left, TreeNode_ right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

public class binary_Tree_PostOrder_Traversal_one_stack {
    public List<Integer> postorderTraversal(TreeNode_ root) {
        List<Integer> finalList = new LinkedList<>();
        if(root == null) return finalList;

        Stack<TreeNode_> st1 = new Stack<>();
        Stack<TreeNode_> st2 = new Stack<>();

        st1.push(root);

        while(!st1.isEmpty()){
            st2.push(st1.pop());
            if(st2.peek().left != null) st1.push(st2.peek().left);
            if(st2.peek().right != null) st1.push(st2.peek().right);

        }

        while(!st2.isEmpty()){
            finalList.add(st2.pop().val);
        }


        return finalList;
    }
}
