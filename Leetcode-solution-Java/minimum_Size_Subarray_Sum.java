import java.util.Arrays;

/**
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a contiguous subarray [numsl, numsl+1, ...,
 * numsr-1, numsr] of which the sum is greater than or equal to target. If there
 * is no such subarray, return 0 instead.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem
 * constraint.
 * Example 2:
 * 
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Example 3:
 * 
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 * 
 * 
 * Constraints:
 * 
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 * 
 * 
 * Follow up: If you have figured out the O(n) solution, try coding another
 * solution of which the time complexity is O(n log(n)).
 */
public class minimum_Size_Subarray_Sum {
    //O(n)
    public int minSubArrayLen(int k, int[] nums) {
        int len = Integer.MAX_VALUE;

        int n = nums.length;
        int i = 0, j = 0;
        int sum = 0;
        while (j < n) {
            sum += nums[j];
            while (sum >= k) {
                len = Math.min(len, j - i + 1);
                sum -= nums[i];
                i++;
            }
            j++;
        }

        if (len == Integer.MAX_VALUE)
            len = 0;
        return len;
    }

    //O(nlogn)
    public int _minSubArrayLen(int k, int[] nums) {
        int len = Integer.MAX_VALUE;

        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            if (prefixSum[i] >= k) {
                int find = prefixSum[i] - k;
                int ind = Arrays.binarySearch(prefixSum, find);

                if (ind < 0) {
                    ind *= -1;
                    ind -= 2;

                }

                len = Math.min(len, i - ind);
            }
        }
        if (len == Integer.MAX_VALUE)
            len = 0;
        return len;
    }
}
