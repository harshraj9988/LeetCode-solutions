    // Given an integer array nums of unique elements, return all possible subsets (the power set).

    // The solution set must not contain duplicate subsets. Return the solution in any order.

    

    // Example 1:

    // Input: nums = [1,2,3]
    // Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    // Example 2:

    // Input: nums = [0]
    // Output: [[],[0]]
    

    // Constraints:

    // 1 <= nums.length <= 10
    // -10 <= nums[i] <= 10
    // All the numbers of nums are unique.
import java.util.*;
public class subsets_ {
    private void subs(int i, int[] array, ArrayList<Integer> alist, List<List<Integer>> result){
        if(i==array.length){
            result.add(new ArrayList<>(alist));
            return;
        }
        
        alist.add(array[i]);
        subs(i+1, array , alist , result);
        alist.remove(alist.size()-1);
        
        
        subs(i+1, array , alist , result);
        
    }
    
    public List<List<Integer>> subsets(int[] nums) {
       ArrayList<Integer> alist=new ArrayList<>();
        List<List<Integer>> result=new ArrayList<>();
        subs(0,nums, alist, result);
        return result;
    }
}
