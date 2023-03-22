
/**
 * Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:

answer[i] % answer[j] == 0, or
answer[j] % answer[i] == 0
If there are multiple solutions, return any of them.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,2]
Explanation: [1,3] is also accepted.
Example 2:

Input: nums = [1,2,4,8]
Output: [1,2,4,8]
 

Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 2 * 109
All the integers in nums are unique.
 */
import java.util.*;

public class largest_Divisible_Subset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        return algo(nums);
    }

    private List<Integer> algo(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] hash = new int[n];

        int max = 1;
        int ind = 0;
        for (int i = 1; i < n; i++) {
            hash[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if(1+dp[j]>dp[i])
                   { dp[i] =  1 + dp[j];
                    hash[i] = j;}
                }
            }
            if(dp[i]>max){
                max = dp[i];
                ind = i;
            }
        }

        
       List<Integer> list = new ArrayList<>();
        list.add(nums[ind]);
        while(hash[ind]!=ind){
            ind = hash[ind];
            list.add(nums[ind]);
        }
        
        return list;
    }

}
