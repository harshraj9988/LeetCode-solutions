/**

 */

import java.util.*;


public class _3Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        int z = 0;
        Arrays.sort(nums);
        for(int i=0; i<n-2; i++){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            int x = z-nums[i];
            for(int j=i+1; j<n-1; j++){
                if(j!=i+1 && nums[j-1]==nums[j]) continue;
                int y = x - nums[j];

                int k = Arrays.binarySearch(nums, j+1, n, y);
                if(k>=0){
                    List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        ans.add(temp);
                }
            }
        }
        return ans;
    }

}

