/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 */
import java.util.*;
public class intersection_OF_Two_Arrays {
    public int[] intersection(int[] nums1, int[] nums2) {       
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);            
        }

        ArrayList<Integer> alist = new ArrayList<>();

        for (int i : nums2) {
            if(set.contains(i)){
                alist.add(i);
                set.remove(i);
            }
        }

        int[] ans = new int[alist.size()];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = alist.get(i);
        }

        return ans;
    }
}
