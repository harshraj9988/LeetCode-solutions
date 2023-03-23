/**
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

 

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
 

Constraints:

1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
 */
import java.util.*;

 public class four_Sum{
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        
        
        for(int i=0; i<n-3; i++ ){
            if(i!=0 && nums[i-1]==nums[i]) continue;

            
            long s = target - nums[i];
            
            for(int j = i+1; j<n-2; j++){
                if(j!=i+1 && nums[j-1]==nums[j]) continue;
                
                long t = s - nums[j];
                
                for(int k = j+1; k<n-1; k++){
                    if(k!=j+1 && nums[k-1]==nums[k]) continue;
                    
                    long u = t - nums[k];
                    
                        for(int l = k+1; l<n; l++){
                        if(l!=k+1 && nums[l-1]==nums[l]) continue;
                        
                        if((long)nums[l] == u) {
                            List<Integer> temp = new ArrayList<>();
                            
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            temp.add(nums[l]);
                            
                            result.add(temp);
                            
                        }
                        
                    }
                }
            }
        }
        return result;
    }
 }