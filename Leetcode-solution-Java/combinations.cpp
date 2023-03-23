/**
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.



Example 1:

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
Example 2:

Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.


Constraints:

1 <= n <= 20
1 <= k <= n
 */
#include <bits/stdc++.h>
using namespace std;
class Solution {
private:
    void combinations(int &n, int &k, int pos, int s, vector<vector<int>> &v, vector<int> &temp)
    {
        if(pos==k){
            v.push_back(temp);
            return;
        }
        for(int i=s; i<=n; i++){
            temp[pos] = i;
            combinations(n, k, pos+1, i+1, v, temp);
        }
    }

public:
    vector<vector<int>> combine(int n, int k)
    {
        vector<vector<int>> ans;
        vector<int> temp(k, 0);
        combinations(n, k, 0, 1, ans, temp);
        return ans;
    }
};