
/**
 * Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Column -1: Only node 9 is in this column.
Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
Column 1: Only node 20 is in this column.
Column 2: Only node 7 is in this column.
Example 2:


Input: root = [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
Column -2: Only node 4 is in this column.
Column -1: Only node 2 is in this column.
Column 0: Nodes 1, 5, and 6 are in this column.
          1 is at the top, so it comes first.
          5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
Column 1: Only node 3 is in this column.
Column 2: Only node 7 is in this column.
Example 3:


Input: root = [1,2,3,4,6,5,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
This case is the exact same as example 2, but with nodes 5 and 6 swapped.
Note that the solution remains the same since 5 and 6 are in the same location and should be ordered by their values.
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
0 <= Node.val <= 1000
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

public class vertical_Order_Traversal_Binary_Tree {

    private ArrayList<NodeData> list;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> finalList = new ArrayList<>();
        if (root == null) {
            return finalList;
        }

        list = new ArrayList<>();
        
        addLevelAndPositionToNodes(root, 0, 0);  //Level = horizonalLevel and Position = verticalLevel
        
        sortList();

        addToList(finalList);

        return finalList;
    }

    private class NodeData {
        int value;
        int level;
        int position;

        NodeData(int value, int level, int position) {
            this.value = value;
            this.level = level;
            this.position = position;
        }
    }

    private void addLevelAndPositionToNodes(TreeNode node, int lev, int pos) {
        if (node == null)
            return;
        list.add(new NodeData(node.val, lev, pos));
        addLevelAndPositionToNodes(node.left, lev + 1, pos - 1);
        addLevelAndPositionToNodes(node.right, lev + 1, pos + 1);
    }

    private void sortList() {
        list.sort(new Comparator<NodeData>() {

            @Override
            public int compare(NodeData node1, NodeData node2) {
                if (node1.position < node2.position)
                    return -1;
                else if (node1.position > node2.position)
                    return 1;
                else {
                    if (node1.level < node2.level)
                        return -1;
                    else if (node1.level > node2.level)
                        return 1;
                    else {
                        if (node1.value < node2.value)
                            return -1;
                        else if (node1.value > node2.value)
                            return 1;
                        else
                            return 0;
                    }
                }
            }
        });
    }

    private void addToList(List<List<Integer>> finalList) {
        int posChange = Integer.MIN_VALUE;
        for (NodeData node : list) {
            if (node.position != posChange) {
                List<Integer> levList = new ArrayList<>();
                levList.add(node.value);
                finalList.add(levList);
                posChange = node.position;
            } else {
                finalList.get(finalList.size() - 1).add(node.value);
            }
        }
    }

}