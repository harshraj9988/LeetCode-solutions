
/**
You are given an array trees where trees[i] = [xi, yi] represents the location of a tree in the garden.

You are asked to fence the entire garden using the minimum length of rope as it is expensive. The garden is well fenced only if all the trees are enclosed.

Return the coordinates of trees that are exactly located on the fence perimeter.

 

Example 1:


Input: points = [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
Output: [[1,1],[2,0],[3,3],[2,4],[4,2]]
Example 2:


Input: points = [[1,2],[2,2],[4,2]]
Output: [[4,2],[2,2],[1,2]]
 

Constraints:

1 <= points.length <= 3000
points[i].length == 2
0 <= xi, yi <= 100
All the given points are unique.
*/

import java.util.*;
import java.io.*;

class Solution {
    public int[][] outerTrees(int[][] trees) {
        int n = trees.length;

        int[] minPoint = getBottomLeftMostPoint(trees);
        sortByPolar(trees, minPoint);

        Stack<int[]> st = new Stack<>();
        st.push(trees[0]);
        st.push(trees[1]);

        for (int i = 2; i < n; i++) {
            int[] top = st.pop();
            while (ccw(trees[i], top, st.peek()) < 0)
                top = st.pop();
            st.push(top);
            st.push(trees[i]);
        }
        int[][] ans = new int[st.size()][2];
        int z = 0;
        for (int[] tree : st) {
            ans[z++] = tree;
        }
        return ans;
    }

    private int[] getBottomLeftMostPoint(int[][] points) {
        int[] pt = new int[2];
        pt[0] = Integer.MAX_VALUE;
        pt[1] = Integer.MAX_VALUE;
        for (int[] point : points) {
            if (point[1] < pt[1] || (point[1] == pt[1] && point[0] < pt[0])) {
                pt[0] = point[0];
                pt[1] = point[1];
            }
        }
        return pt;
    }

    private void sortByPolar(int[][] points, int[] z) {
        Arrays.sort(points, (x, y) -> {
            int compPolar = ccw(y, x, z);
            int compDist = dist(x, z) - dist(y, z);
            return (compPolar == 0) ? compDist : compPolar;
        });
        int j = points.length;
        int[] y = points[j - 1];
        int i = j - 2;
        while (i >= 0 && (ccw(points[i], y, z) == 0))
            i--;
        i++;
        j--;
        while (i < j) {
            swap(points[i++], points[j--]);
        }
    }

    private int ccw(int[] x, int[] y, int[] z) {
        return (((x[0] - z[0]) * (y[1] - z[1])) - ((x[1] - z[1]) * (y[0] - z[0])));
    }

    private int dist(int[] x, int[] y) {
        return (((x[0] - y[0]) * (x[0] - y[0])) + ((x[1] - y[1]) * (x[1] - y[1])));
    }

    private void swap(int[] x, int y[]) {
        int a = x[0], b = x[1];
        x[0] = y[0];
        x[1] = y[1];
        y[0] = a;
        y[1] = b;
    }
}