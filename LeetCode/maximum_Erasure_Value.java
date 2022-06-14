import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * You are given an array of positive integers nums and want to erase a subarray
 * containing unique elements. The score you get by erasing the subarray is
 * equal to the sum of its elements.
 * 
 * Return the maximum score you can get by erasing exactly one subarray.
 * 
 * An array b is called to be a subarray of a if it forms a contiguous
 * subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some
 * (l,r).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [4,2,4,5,6]
 * Output: 17
 * Explanation: The optimal subarray here is [2,4,5,6].
 * Example 2:
 * 
 * Input: nums = [5,2,1,2,5,2,1,2,5]
 * Output: 8
 * Explanation: The optimal subarray here is [5,2,1] or [1,2,5].
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 */

public class maximum_Erasure_Value {
    public int maximumUniqueSubarray(int[] nums) {
        int i = 0 , j = 0 , max = 0, currMax =0;
        HashSet<Integer> set = new HashSet<>();
        while(i<nums.length && j<nums.length){
            if(!set.contains(nums[j])){
                set.add(nums[j]);
                currMax += nums[j];
                max = (max>currMax)? max: currMax;
                j++;
            }else{
                set.remove(nums[i]);
                currMax -= nums[i];
                i++;
            }
        }
        return max;
    }
}