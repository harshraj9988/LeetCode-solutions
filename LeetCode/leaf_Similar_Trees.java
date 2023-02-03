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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> leafs1 = new ArrayList<>(), leafs2 = new ArrayList<>();
        getLeafNodes(root1, leafs1);
        getLeafNodes(root2, leafs2);
        return leafs1.equals(leafs2);
    }

    private void getLeafNodes(TreeNode node, ArrayList<Integer> leafs) {
        if(node.left==null && node.right==null){
            leafs.add(node.val);
            return;
        }
        if(node.left!=null) getLeafNodes(node.left, leafs);
        if(node.right!=null) getLeafNodes(node.right, leafs);
    }
}