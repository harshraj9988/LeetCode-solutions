    // Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

    // Each number in candidates may only be used once in the combination.

    // Note: The solution set must not contain duplicate combinations.

    

    // Example 1:

    // Input: candidates = [10,1,2,7,6,1,5], target = 8
    // Output: 
    // [
    // [1,1,6],
    // [1,2,5],
    // [1,7],
    // [2,6]
    // ]
    // Example 2:

    // Input: candidates = [2,5,2,1,2], target = 5
    // Output: 
    // [
    // [1,2,2],
    // [5]
    // ]
    

    // Constraints:

    // 1 <= candidates.length <= 100
    // 1 <= candidates[i] <= 50
    // 1 <= target <= 30
import java.util.*;
public class combination_Sum_2 {
    private void cs2(int i, int[] array, ArrayList<Integer> alist, int target, List<List<Integer>> result){
       
        if(target==0){
            result.add(new ArrayList<>(alist));
            return; 
        }
        
    
    

       for(int j=i;j<array.length;j++){
           if(j>i && array[j]==array[j-1]) continue;
            if(array[j]>target) break;

            
            alist.add(array[j]);
            cs2(j+1, array, alist, target-array[j], result);
            alist.remove(alist.size()-1);

       }
       

    
    
}


public List<List<Integer>> combinationSum2(int[] candidates, int target){
    List<List<Integer>> result=new ArrayList<>();
    ArrayList<Integer> alist=new ArrayList<>();
    Arrays.sort(candidates);
    cs2(0, candidates, alist, target, result);

    return result;
}
}
