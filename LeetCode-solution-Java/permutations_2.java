    // Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

    

    // Example 1:

    // Input: nums = [1,1,2]
    // Output:
    // [[1,1,2],
    // [1,2,1],
    // [2,1,1]]
    // Example 2:

    // Input: nums = [1,2,3]
    // Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    

    // Constraints:

    // 1 <= nums.length <= 8
    // -10 <= nums[i] <= 10
import java.util.*;
public class permutations_2 {
    private void permute(int i, ArrayList<Integer> alist, List<List<Integer>> result){
        if(i==alist.size()){
            result.add(new ArrayList<>(alist));
        return;
        }
        int[] map=new int[21];
        for(int j=i;j<alist.size();j++){
            if( map[alist.get(j)+10]==1) continue;
            map[alist.get(j)+10]=1;
            int temp1=alist.get(i);
            alist.set(i, alist.get(j));
            alist.set(j, temp1);
            permute(i+1, alist, result);
            int temp2=alist.get(i);
            alist.set(i, alist.get(j));
            alist.set(j, temp2);
            
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        ArrayList<Integer> alist=new ArrayList<>();
        
        for (int item : nums) {
            alist.add(item);         
        }
        permute(0,  alist, result);
        return result;
    }
}
