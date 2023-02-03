/**
Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

 

Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation: 
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.

Example 2:

Input: arr = [11,81,94,43,3]
Output: 444

 

Constraints:

    1 <= arr.length <= 3 * 104
    1 <= arr[i] <= 3 * 104


*/

import java.util.*;
import java.io.*;
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n], right = new int[n];
        long sumOfMinis = 0l;
        long mod = (long)1e9 + 7l;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]) st.pop();
            left[i] = -1;
            if(!st.isEmpty()) left[i] = st.peek();
            st.push(i); 
        }
        st.clear();
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && arr[st.peek()]>arr[i]) st.pop();
            right[i] = n;
            if(!st.isEmpty()) right[i] = st.peek();
            st.push(i); 
        }

        for(int i=0; i<n; i++) {
            sumOfMinis = (sumOfMinis + ( (long)(i-left[i])*(long)(right[i]-i)*(long)arr[i])%mod)%mod;
        }
        
        return (int)sumOfMinis;
    }
}