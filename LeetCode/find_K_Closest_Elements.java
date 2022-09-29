
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
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        int ind = Arrays.binarySearch(arr, x);
        if (ind < 0) {
            ind = (-1 * ind) - 1;
        }
        int i = ind - 1;
        int j = ind;
        while (k > 0 && i >= 0 && j < n) {
            int left = x - arr[i];
            int right = arr[j] - x;
            if (left < right) {
                list.add(arr[i]);
                i--;
            } else if (left > right) {
                list.add(arr[j]);
                j++;
            } else {
                if (arr[i] < arr[j]) {
                    list.add(arr[i]);
                    i--;
                } else {
                    list.add(arr[j]);
                    j++;
                }
            }
            k--;
        }

        while (k > 0 && i >= 0) {
            list.add(arr[i]);
            i--;
            k--;
        }
        while (k > 0 && j < n) {
            list.add(arr[j]);
            j++;
            k--;
        }
        Collections.sort(list);
        return list;
    }
}