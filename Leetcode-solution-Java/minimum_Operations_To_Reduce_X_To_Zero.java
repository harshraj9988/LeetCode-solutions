/**
 * You are given an integer array nums and an integer x. In one operation, you
 * can either remove the leftmost or the rightmost element from the array nums
 * and subtract its value from x. Note that this modifies the array for future
 * operations.
 * 
 * Return the minimum number of operations to reduce x to exactly 0 if it is
 * possible, otherwise, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,4,2,3], x = 5
 * Output: 2
 * Explanation: The optimal solution is to remove the last two elements to
 * reduce x to zero.
 * Example 2:
 * 
 * Input: nums = [5,6,7,8,9], x = 4
 * Output: -1
 * Example 3:
 * 
 * Input: nums = [3,2,20,1,1,3], x = 10
 * Output: 5
 * Explanation: The optimal solution is to remove the last three elements and
 * the first two elements (5 operations in total) to reduce x to zero.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 * 1 <= x <= 109
 */

public class minimum_Operations_To_Reduce_X_To_Zero {
    public int minOperations(int[] nums, int x) {
        if (nums.length == 1 && x != nums[0])
            return -1;

        int totalSum = 0;

        for (int i = 0; i < nums.length; i++) {
            totalSum = totalSum + nums[i];
        }

        int target = totalSum - x;

        if (target < 0)
            return -1;
        if (target == 0)
            return nums.length;

        int steps = 0;
        int i = 0;
        int j = 0;

        while (j < nums.length) {
            target -= nums[j];
            j++;

            while (target < 0) {
                target += nums[i];
                i++;
            }

            if (target == 0) {
                steps = ((j - i) > steps) ? (j - i) : steps;
            }

        }

        return (steps == 0) ? -1 : nums.length - steps;

    }
}
