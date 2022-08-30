import java.util.*;
import java.util.Map.Entry;

import javax.swing.GrayFilter;

public class cc {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        Map<Integer, int[]> map = new HashMap<>();
        for(int i=1; i<=k ; i++){
            map.put(i, new int[]{0,0});
        }

        for(int[] i: rowConditions){
            map.get(i[1])[0]= map.get(i[0])[0]+1;
        }

        for(int[] i: colConditions){
            map.get(i[1])[1]= map.get(i[0])[1]+1;
        }

        int[][] ans = new int[k][k];


        for(Entry<Integer, int[]> i:map.entrySet()){
            int[] xy = i.getValue();
            ans[xy[0]][xy[1]] = i.getKey();
        }

        for(int[] i: ans){
            System.out.println(Arrays.toString(i));
        }

        return rowConditions;
    }

    public static void main(String[] args) {
        int k = 3;
        int[][] rowConditions = {{1,2},{3,2}};
        int[][] colConditions = {{2,1},{3,2}};
        new cc().buildMatrix(k, rowConditions, colConditions);
    }
}