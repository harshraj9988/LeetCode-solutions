/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var zigzagLevelOrder = function (root) {
    let ans = [];
    if(root == null) return ans;
    let queue = [];
    let zig = true;
    queue.push(root);
    while (queue.length > 0) {
        let list = [];
        let size = queue.length;
        for (let i = 0; i < size; i++) {
            let node = queue.shift();
            list.push(node.val);
            if (node.left != null) {
                queue.push(node.left);
            }
            if (node.right != null) {
                queue.push(node.right);
            }
        }
        ans.push(zig ? list : list.reverse());
        zig = !zig;
    }
    return ans;
};
