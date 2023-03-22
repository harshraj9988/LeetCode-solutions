import java.util.*;

/**
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
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


public class binary_Tree_ZigZag_Level_Order_Traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> finalList = new ArrayList<>();
        if(root == null) return finalList;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<queueSize; i++){
                    if(queue.peek().left!=null) queue.offer(queue.peek().left);
                    if(queue.peek().right!=null) queue.offer(queue.peek().right);
                    list.add(queue.poll().val);
            }
            finalList.add(list);
        }
        
        for(int i=1; i<finalList.size(); i++){
            if(i%2==1) Collections.reverse(finalList.get(i));
        }
        
        return finalList;
    }
}
