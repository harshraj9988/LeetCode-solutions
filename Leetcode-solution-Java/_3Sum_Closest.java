
/**
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Example 2:

Input: nums = [0,0,0], target = 1
Output: 0

 

Constraints:

    3 <= nums.length <= 1000
    -1000 <= nums[i] <= 1000
    -104 <= target <= 104


*/

import java.util.*;

public class _3Sum_Closest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int x = 0, y = 0, z = 0;
        int diff = 0;
        int maxSum = Integer.MIN_VALUE;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            x = target - nums[i];
            for (int j = i + 1; j < n - 1; j++) {
                y = x - nums[j];
                z = Arrays.binarySearch(nums, j + 1, n, y);
                if (z >= 0)
                    return target;
                else {
                    z = (z + 1) * (-1);
                    if(z==n) {
                        diff = Math.abs(nums[z-1] - y);
                        if (diff < minDiff) {
                            minDiff = diff;
                            maxSum = nums[i] + nums[j] + nums[z-1];
                        }
                    }
                    else if (z == n - 1) {
                        
                        diff = Math.abs(nums[z] - y);
                        if (diff < minDiff) {
                            minDiff = diff;
                            maxSum = nums[i] + nums[j] + nums[z];
                        }
                    } else {
                        
                        diff = Math.abs(nums[z] - y);
                        if (diff < minDiff) {
                            minDiff = diff;
                            maxSum = nums[i] + nums[j] + nums[z];
                        }
                        diff = Math.abs(nums[z+1] - y);
                        if (diff < minDiff) {
                            minDiff = diff;
                            maxSum = nums[i] + nums[j] + nums[z+1];
                        }
                    }
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 5, 8, 9 };
        System.out.println(Arrays.binarySearch(arr, 0, 3, 9));
    }
}