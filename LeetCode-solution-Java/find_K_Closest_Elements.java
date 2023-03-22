
/**
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 

Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]
 

Constraints:

1 <= k <= arr.length
1 <= arr.length <= 104
arr is sorted in ascending order.
-104 <= arr[i], x <= 104
*/

import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int i = 0, j = arr.length - 1;
        while ((j - i + 1) > k) {
            int left = x - arr[i];
            int right = arr[j] - x;
            if(right>left) j--;
            else if(right<left) i++;
            else {
                if(arr[i]>arr[j]) i++;
                else j--;
            }
        }
        while (i <= j) {
            list.add(arr[i++]);
        }
        return list;
    }
}