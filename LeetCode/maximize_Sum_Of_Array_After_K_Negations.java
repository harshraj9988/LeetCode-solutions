import java.util.Arrays;

/**
 * Given an integer array nums and an integer k, modify the array in the following way:

    choose an index i and replace nums[i] with -nums[i].

You should apply this process exactly k times. You may choose the same index i multiple times.

Return the largest possible sum of the array after modifying it in this way.

 

Example 1:

Input: nums = [4,2,3], k = 1
Output: 5
Explanation: Choose index 1 and nums becomes [4,-2,3].

Example 2:

Input: nums = [3,-1,0,2], k = 3
Output: 6
Explanation: Choose indices (1, 2, 2) and nums becomes [3,1,0,2].

Example 3:

Input: nums = [2,-3,-1,5,-4], k = 2
Output: 13
Explanation: Choose indices (1, 4) and nums becomes [2,3,-1,5,4].

 

Constraints:

    1 <= nums.length <= 104
    -100 <= nums[i] <= 100
    1 <= k <= 104


 */

public class maximize_Sum_Of_Array_After_K_Negations{
    public int largestSumAfterKNegations(int[] nums, int k) {
       
        int sum = 0;
        

        Arrays.sort(nums);

        for (int i = 0; k > 0 ; i++) {
            if(nums[i] < 0){
                k--;
                nums[i] = nums[i] * (-1);

                if(i==nums.length-1){
                    i = 0;
                }

            }
            else if(nums[i]==0){
                k = 0;
            }
            else{
                if(k%2  == 0){
                    k=0;
                }
                else{
                    Arrays.sort(nums);
                    nums[0] = nums[0] * (-1);
                    k=0;
                }
            }
        }

        for (int i : nums) {
            sum += i;
        }

        return sum;
    }
}