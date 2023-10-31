    // Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

    // The solution set must not contain duplicate subsets. Return the solution in any order.

    

    // Example 1:

    // Input: nums = [1,2,2]
    // Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
    // Example 2:

    // Input: nums = [0]
    // Output: [[],[0]]
    

    // Constraints:

    // 1 <= nums.length <= 10
    // -10 <= nums[i] <= 10
import java.util.*;
public class subsets_2 {
    private void ss(int i, int[] array, ArrayList<Integer> alist, List<List<Integer>> result){
       
        result.add(new ArrayList<>(alist));
  
   
    for(int j=i;j<array.length;j++){
           if(j>i && array[j]==array[j-1]) continue;
        
        alist.add(array[j]);
        ss(j+1,array,alist,result);
        alist.remove(alist.size()-1);
    }
         
    
}

public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result=new ArrayList<>();
    ArrayList<Integer> alist=new ArrayList<>();
    Arrays.sort(nums);
    ss(0,nums,alist,result);
    return result;
}
}
