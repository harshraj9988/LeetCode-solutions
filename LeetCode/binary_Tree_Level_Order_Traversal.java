    // Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

    

    // Example 1:
    //                 3
    //             / \
    //             /   \  
    //             9    20
    //                 / \
    //                 /   \
    //                 15    7

    // Input: root = [3,9,20,null,null,15,7]
    // Output: [[3],[9,20],[15,7]]
    // Example 2:

    // Input: root = [1]
    // Output: [[1]]
    // Example 3:

    // Input: root = []
    // Output: []
    

    // Constraints:

    // The number of nodes in the tree is in the range [0, 2000].
    // -1000 <= Node.val <= 1000

    import java.util.*;

    // this class was given in the question
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  
 
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> finalList = new LinkedList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        if(root == null) return finalList;
        
        queue.offer(root);
        while(!queue.isEmpty()){
            int level = queue.size();
            List<Integer> list = new LinkedList<>();
            for(int i=0;i<level;i++){
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
               list.add(queue.poll().val);
            }
            finalList.add(list);
        }
        return finalList;
    }
}