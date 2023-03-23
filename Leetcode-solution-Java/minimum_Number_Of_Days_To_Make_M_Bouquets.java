
/**

*/

import java.util.*;
import java.io.*;

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if((long)m*(long)k>(long)n) return -1;
        int s=1, e = (int)1e9;
        while(s<e){
            int mid = (s+(e-s)/2);
            int a = m;
            int b = 0;
            for(int bDay: bloomDay){
                if(bDay<=mid) b++;
                else b=0;
                if(b==k){
                    b = 0;
                    a--;
                }
            }
            if(a<=0) e = mid;
            else s = mid+1;
        }
        return s;
    }
}