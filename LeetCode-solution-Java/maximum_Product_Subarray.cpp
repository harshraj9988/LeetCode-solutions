/**
Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.



Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.


Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 */

#include <bits/stdc++.h>
using namespace std;
class Solution
{
public:
    int maxProduct(vector<int> &nums)
    {
        int maxProd = INT_MIN;
        int prod = 1;
        int n = nums.size();
        for (int i = 0; i < n; i++)
        {
            prod *= nums[i];
            maxProd = max(prod, maxProd);
            if (prod == 0)
                prod = 1;
        }
        prod = 1;
        for (int i = n - 1; i >= 0; i--)
        {
            prod *= nums[i];
            maxProd = max(prod, maxProd);
            if (prod == 0)
                prod = 1;
        }
        return maxProd;
    }
};