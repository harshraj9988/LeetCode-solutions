/**
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.



Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.


Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length
*/

#include <bits/stdc++.h>
using namespace std;
class Solution
{
public:
    int longestOnes(vector<int> &nums, int k)
    {
        int maxCount = 0;
        int count = 0;
        int n = nums.size();
        int s = 0;
        for (int e = 0; e < n; e++)
        {
            if (nums[e] == 1)
            {
                count++;
            }
            else if (nums[e] == 0 && k > 0)
            {
                k--;
                count++;
            }
            else
            {
                if (nums[s] == 0)
                {
                    k++;
                }
                count--;
                s++;
                e--;
            }

            maxCount = max(maxCount, count);
        }

        return maxCount;
    }
};