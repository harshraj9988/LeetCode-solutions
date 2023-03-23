/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 

Example 1:


Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
Example 2:

Input: root = [1,null,3]
Output: [1,3]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
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


public class binary_Tree_Right_Side_View {
    private Integer maxLevel;
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> finalList = new ArrayList<>();
        
        if(root == null) return finalList;
        
        maxLevel = -1;
        solve(root, finalList, 0);
        
        return finalList;
    }
    
    private void solve(TreeNode node, List<Integer> list, int level){
        if(node == null) return;
        
        if(maxLevel<level){
            maxLevel = level;
            list.add(node.val);
        }
        solve(node.right, list, level+1);
        solve(node.left, list, level+1);
    }
}
