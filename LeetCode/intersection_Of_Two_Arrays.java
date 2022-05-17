    // Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

    

    // Example 1:

    // Input: nums1 = [1,2,2,1], nums2 = [2,2]
    // Output: [2,2]
    // Example 2:

    // Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    // Output: [4,9]
    // Explanation: [9,4] is also accepted.
    

    // Constraints:

    // 1 <= nums1.length, nums2.length <= 1000
    // 0 <= nums1[i], nums2[i] <= 1000

    import java.util.*;
    public class intersection_Of_Two_Arrays{
        public int[] intersect(int[] nums1, int[] nums2) {
            int[] map=new int[1001];
            ArrayList<Integer> array=new ArrayList<>();
            for (Integer ind : nums1) {
                map[ind]++;                
            }
            for (Integer idx : nums2) {
                if(map[idx]>=1){
                    array.add(idx);                
                    map[idx]--;
                }
            }
            int[] result = new int[array.size()];
            for (int i = 0; i < result.length; i++) {
                result[i]=array.get(i);
            }
            return result;
        }
    }