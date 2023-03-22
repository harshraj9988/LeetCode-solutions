    // Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    // You may assume that each input would have exactly one solution, and you may not use the same element twice.
    // You can return the answer in any order.

    // Example 1:

    // Input: nums = [2,7,11,15], target = 9
    // Output: [0,1]
    // Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].


    // Example 2:
    
    // Input: nums = [3,2,4], target = 6
    // Output: [1,2]


    // Example 3:
    
    // Input: nums = [3,3], target = 6
    // Output: [0,1]

import java.util.*;

public class two_Sum {
    public int[] twoSum(int[] nums, int target) {
        int [] temp=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            temp[i]=nums[i];
        }
        Arrays.sort(temp);
        int n=target;
        int i=0;
        int j=temp.length-1;
       while(i<j){
           if(temp[i]+temp[j]<n){
            i++;
           }
           else if(temp[i]+temp[j]>n){
            j--;
           }
           else{
            
            break;
           }
       }
      
        int k;
        ArrayList<Integer> ans=new ArrayList<>();
        for(k=0;k<nums.length;k++){
            if(nums[k]==temp[i]) {
                ans.add(k); 
            }
            else if(nums[k]==temp[j]){
                ans.add(k);
            }
        }
        
        
        int[] ans1={ans.get(0),ans.get(1)};
       
        return ans1;
    }
}
