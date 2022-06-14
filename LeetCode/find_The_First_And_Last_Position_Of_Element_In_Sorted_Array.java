import java.util.Arrays;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the
 * starting and ending position of a given target value.
 * 
 * If target is not found in the array, return [-1, -1].
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 * 
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 * 
 * 
 * Constraints:
 * 
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 * 
 * 
 */
public class find_The_First_And_Last_Position_Of_Element_In_Sorted_Array {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || (nums.length == 1 && nums[0] != target))
            return new int[] { -1, -1 };
        if (nums.length == 1 && nums[0] == target)
            return new int[] { 0, 0 };
        if (nums[0] == nums[nums.length - 1] && nums[0] == target)
            return new int[] { 0, nums.length - 1 };

        int i = Arrays.binarySearch(nums, target);
        if (i >= 0) {
            int a = 0;
            int b = nums.length - 1;

            if (nums[0] != target) { // for a

                int x = i;
                a = x;
                while (x >= 0 && nums[x - 1] == target) {

                    x = Arrays.binarySearch(nums, 0, x, target);
                    if (x >= 0)
                        a = x;
                }

            }

            if (nums[nums.length - 1] != target) { // for b

                int y = i;
                b = y;
                while (y < nums.length && nums[y + 1] == target) {

                    y = Arrays.binarySearch(nums, y + 1, nums.length, target);
                    if (y >= 0)
                        b = y;
                }

            }

            return new int[] { a, b };

        } else {
            return new int[] { -1, -1 };
        }
    }
}
