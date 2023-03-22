import java.util.*;

/**
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 * <p>
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * <p>
 * Return intervals after the insertion.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 * <p>
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 105
 * intervals is sorted by starti in ascending order.
 * newInterval.length == 2
 * 0 <= start <= end <= 105
 */

public class insert_Interval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
       if(intervals.length == 0) return new int[][]{newInterval};

       int start = newInterval[0];
       int end = newInterval[1];

       List<int[]> list = new ArrayList<>();

       int i=0;
       while( i< intervals.length && intervals[i][1] < start){
           list.add(new int[]{intervals[i][0],intervals[i][1]});
           i++;
       }

       while( i < intervals.length){
           if( intervals[i][0] <= end){
               start = Math.min(start, intervals[i][0]);
               end = Math.max(end, intervals[i][1]);
           }
           else{
               list.add(new int[]{start,end});
               start = intervals[i][0];
               end = intervals[i][1];
           }
           i++;
       }
       list.add(new int[]{start,end});

       int[][] result = list.toArray(new int[list.size()][2]);

       return result;
    }
}
