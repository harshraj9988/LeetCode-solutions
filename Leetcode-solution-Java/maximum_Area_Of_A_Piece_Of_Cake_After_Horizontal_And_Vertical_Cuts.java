
/**
 * You are given a rectangular cake of size h x w and two arrays of integers horizontalCuts and verticalCuts where:

horizontalCuts[i] is the distance from the top of the rectangular cake to the ith horizontal cut and similarly, and
verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut.
Return the maximum area of a piece of cake after you cut at each horizontal and vertical position provided in the arrays horizontalCuts and verticalCuts. Since the answer can be a large number, return this modulo 109 + 7.

 

Example 1:


Input: h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
Output: 4 
Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal and vertical cuts. After you cut the cake, the green piece of cake has the maximum area.
Example 2:


Input: h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]
Output: 6
Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal and vertical cuts. After you cut the cake, the green and yellow pieces of cake have the maximum area.
Example 3:

Input: h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3]
Output: 9
 

Constraints:

2 <= h, w <= 109
1 <= horizontalCuts.length <= min(h - 1, 105)
1 <= verticalCuts.length <= min(w - 1, 105)
1 <= horizontalCuts[i] < h
1 <= verticalCuts[i] < w
All the elements in horizontalCuts are distinct.
All the elements in verticalCuts are distinct.
 */
import java.util.*;

public class maximum_Area_Of_A_Piece_Of_Cake_After_Horizontal_And_Vertical_Cuts {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        long maxSliceHeight = findMaxSliceHeight(horizontalCuts, h);
        long maxSliceWidth = findMaxSliceWidth(verticalCuts, w);
        
        final long MOD_CALCULATOR = 1000000007;

        return (int)((maxSliceHeight*maxSliceWidth)%MOD_CALCULATOR);
    }

    private int findMaxSliceHeight(int[] horizontalCuts , int h){
        int maxSliceHeight = 0;
        int sizeMinusOneOfHorizonalCuts = horizontalCuts.length-1;
        int firstIntermeditateLength = horizontalCuts[0]-0;
        maxSliceHeight =  (maxSliceHeight > firstIntermeditateLength)? maxSliceHeight : firstIntermeditateLength;
        for (int i = 0; i < sizeMinusOneOfHorizonalCuts; i++) {
            int intermediateSliceHeight = horizontalCuts[i+1] - horizontalCuts[i];
            maxSliceHeight =  (maxSliceHeight > intermediateSliceHeight)? maxSliceHeight : intermediateSliceHeight;
        }
        firstIntermeditateLength = h - horizontalCuts[sizeMinusOneOfHorizonalCuts];
        maxSliceHeight =  (maxSliceHeight > firstIntermeditateLength)? maxSliceHeight : firstIntermeditateLength;
        return maxSliceHeight;
    }

    private int findMaxSliceWidth(int[] verticalCuts, int w){
        int maxSliceWidth = 0;
        int sizeMinusOneOfVerticalCuts = verticalCuts.length-1;
        int firstIntermeditateLength = verticalCuts[0]-0;
        maxSliceWidth =  (maxSliceWidth > firstIntermeditateLength)? maxSliceWidth : firstIntermeditateLength;
        for (int i = 0; i < sizeMinusOneOfVerticalCuts; i++) {
            int intermediateSliceWidht = verticalCuts[i+1] - verticalCuts[i];
            maxSliceWidth =  (maxSliceWidth > intermediateSliceWidht)? maxSliceWidth : intermediateSliceWidht;
        }
        firstIntermeditateLength = w - verticalCuts[sizeMinusOneOfVerticalCuts];
        maxSliceWidth =  (maxSliceWidth > firstIntermeditateLength)? maxSliceWidth : firstIntermeditateLength;
        return maxSliceWidth;
    }
}
