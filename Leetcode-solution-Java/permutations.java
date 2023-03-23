    // Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

    

    // Example 1:

    // Input: nums = [1,2,3]
    // Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    // Example 2:

    // Input: nums = [0,1]
    // Output: [[0,1],[1,0]]
    // Example 3:

    // Input: nums = [1]
    // Output: [[1]]
    

    // Constraints:

    // 1 <= nums.length <= 6
    // -10 <= nums[i] <= 10
    // All the integers of nums are unique.
import java.util.*;
public class permutations {
    private void permut(int i, ArrayList<Integer> alist, List<List<Integer>> result){
        if(i==alist.size()){
            result.add(new ArrayList<>(alist));
        return;
        }
        for(int j=i;j<alist.size();j++){
            int temp1=alist.get(i);
            alist.set(i, alist.get(j));
            alist.set(j, temp1);
            permut(i+1, alist, result);
            int temp2=alist.get(i);
            alist.set(i, alist.get(j));
            alist.set(j, temp2);

        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        ArrayList<Integer> alist=new ArrayList<>();
        for(int item : nums){
            alist.add(item);
        }
        permut(0,alist,result);
        return result;
    }
}
