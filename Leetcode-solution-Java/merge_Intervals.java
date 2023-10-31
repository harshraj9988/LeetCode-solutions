    // Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

    

    // Example 1:

    // Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    // Output: [[1,6],[8,10],[15,18]]
    // Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
    // Example 2:

    // Input: intervals = [[1,4],[4,5]]
    // Output: [[1,5]]
    // Explanation: Intervals [1,4] and [4,5] are considered overlapping.
    

    // Constraints:

    // 1 <= intervals.length <= 104
    // intervals[i].length == 2
    // 0 <= starti <= endi <= 104
import java.util.*;
public class merge_Intervals {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,(int[] c, int[] d)->{return c[0]-d[0];});       
        
        
        
        int n=intervals.length;
       

        int k=0;
        
        for(int i=0;i<n;i++){
            if( intervals[k][1]>=intervals[i][0]  ){
                if(intervals[k][1]<=intervals[i][1])
                    intervals[k][1]=intervals[i][1];
            }
            else{
                k++;
                intervals[k][0]=intervals[i][0];
                intervals[k][1]=intervals[i][1];
            }
        }

       int[][] temp= new int[k+1][2];
        for (int i = 0; i < temp.length; i++) {
            temp[i][0]=intervals[i][0];
            temp[i][1]=intervals[i][1];
            
        }

        
       
        
        return temp;
    }
}
