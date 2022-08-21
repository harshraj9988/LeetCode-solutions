/**
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4
 

Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104
 */
import java.util.*;
public class largest_Rectangle_In_Histogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for(int i=0; i<=n; i++) {
            while(!st.empty() && (i==n || heights[st.peek()]>=heights[i])) {
                int height = heights[st.pop()];
                int width = i;
                if(!st.empty()) width = i - st.peek()-1;
                maxArea = Math.max(maxArea, height*width);
            }
            st.push(i);
        }

        return maxArea;
    }
}
