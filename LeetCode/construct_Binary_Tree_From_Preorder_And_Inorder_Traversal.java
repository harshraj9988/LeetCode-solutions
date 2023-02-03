/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 

Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.
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


public class construct_Binary_Tree_From_Preorder_And_Inorder_Traversal{
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = inorder.length;
        int m = preorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return tree(preorder, 0, m-1, inorder, 0, n-1, map);
    }

    private TreeNode tree(int[] pre, int ps, int pe , int[] in, int is, int ie, HashMap<Integer, Integer> map){
       
        if(ps>pe || is>ie) return null;

        TreeNode root = new TreeNode(pre[ps]);
       
        int ir = map.get(root.val);
        int len = ir - is;

        root.left = tree(pre, ps+1, ps+len , in, is, ir-1, map);
        root.right = tree(pre, ps+len+1, pe, in, ir+1, ie, map);

        return root;
    }
}