/**
 * Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.


Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [3.00000,14.50000,11.00000]
Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
Hence return [3, 14.5, 11].
Example 2:


Input: root = [3,9,20,15,7]
Output: [3.00000,14.50000,11.00000]


Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
 */

#include <bits/stdc++.h>
using namespace std;

struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution
{
private:
    void bfs(TreeNode *root, vector<double> &arr)
    {
        if (!root)
            return;
        queue<TreeNode *> q;
        q.push(root);
        arr.push_back(root->val);
        while (!q.empty())
        {
            int size = q.size();
            double sum = 0;
            double count = 0;
            while (size--)
            {
                TreeNode *node = q.front();
                q.pop();
                if (node->left)
                {
                    sum+=node->left->val;
                    count++;
                    q.push(node->left);
                }
                if (node->right)
                {
                    sum+=node->right->val;
                    count++;
                    q.push(node->right);
                }
            }
            sum /= count;
            arr.push_back(sum);
        }
    }

public:
    vector<double> averageOfLevels(TreeNode *root)
    {
        vector<double> arr;
        bfs(root, arr);
        return arr;
    }
};