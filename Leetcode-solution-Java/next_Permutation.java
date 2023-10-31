    // A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

    // For example, for arr = [1,2,3], the following are considered permutations of arr: [1,2,3], [1,3,2], [3,1,2], [2,3,1].
    // The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

    // For example, the next permutation of arr = [1,2,3] is [1,3,2].
    // Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
    // While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
    // Given an array of integers nums, find the next permutation of nums.

    // The replacement must be in place and use only constant extra memory.

    

    // Example 1:

    // Input: nums = [1,2,3]
    // Output: [1,3,2]
    // Example 2:

    // Input: nums = [3,2,1]
    // Output: [1,2,3]
    // Example 3:

    // Input: nums = [1,1,5]
    // Output: [1,5,1]
    

    // Constraints:

    // 1 <= nums.length <= 100
    // 0 <= nums[i] <= 100

public class next_Permutation {
    public void nextPermutation(int[] nums) {
        int n=nums.length-1;
        if(n+1<=1) return;
        
        int temp=0;
        boolean flag=false;
        
        
        int j=n;
        int k=n;
        
            while(nums[j]<=nums[j-1] && j>1){
                j--;
            }
            if(nums[j]>nums[j-1]){
                while(nums[k]<=nums[j-1]) k--;
                flag=true;
                temp=nums[k];
                nums[k]=nums[j-1];
                nums[j-1]=temp;
               
                for (int a = n, b=j; a > b; a--,b++) {
                    temp=nums[a];
                    nums[a]=nums[b];
                    nums[b]=temp;
                }
                
            }

        if(flag==false){
            for (int i = 0; i < (n+1)/2 ; i++) {
                temp=nums[i];
                nums[i]=nums[n-i];
                nums[n-i]=temp;
            }    
                  
        }
    }
}