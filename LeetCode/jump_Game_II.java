/**
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 1000
 */
public class jump_Game_II {
    private Integer[] min;
    
    private int check(int[] nums, int i){
        if(min[i] != null) return min[i];
        if(i==nums.length-1) return 0;
        if(nums[i]>=nums.length-1-i){
            return 1;
        }
        if(nums[i]==0 && i < nums.length-1)
            return Integer.MAX_VALUE;
        
        int temp = Integer.MAX_VALUE-1;
        
        for(int j=1; j<=nums[i];j++){
            temp = Math.min(temp, check(nums, i+j));
        }
        
        return min[i]=temp+1;
    }
    
    public int jump(int[] nums) {
        min = new Integer[nums.length];
        return check(nums, 0);
    }
}
