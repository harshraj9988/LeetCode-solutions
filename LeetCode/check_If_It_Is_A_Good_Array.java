/**
    Given an array nums of positive integers. Your task is to select some subset of nums, multiply each element by an integer and add all these numbers. The array is said to be good if you can obtain a sum of 1 from the array by any possible subset and multiplicand.

    Return True if the array is good otherwise return False.

    

    Example 1:

    Input: nums = [12,5,7,23]
    Output: true
    Explanation: Pick numbers 5 and 7.
    5*3 + 7*(-2) = 1
    Example 2:

    Input: nums = [29,6,10]
    Output: true
    Explanation: Pick numbers 29, 6 and 10.
    29*1 + 6*(-3) + 10*(-1) = 1
    Example 3:

    Input: nums = [3,6]
    Output: false
*/

public class check_If_It_Is_A_Good_Array {
    public boolean isGoodArray(int[] nums) {
      if(nums.length == 1 && nums[0] == 1) return true;

      int hcf = nums[0];

      for (int i = 1; i < nums.length; i++) {
        
        int a = Math.max(nums[i], hcf);
        int b = Math.min(nums[i], hcf);
        int r = b;

        while(a%b != 0){
            r = a%b;
            a = b;
            b = r;
        }

        hcf = r;
        if(hcf == 1)    return true;
      }
      return false;
    }

    public static void main(String[] args) {
        int[] nums = {3,6};

        System.out.println(new check_If_It_Is_A_Good_Array().isGoodArray(nums));
    }
}
