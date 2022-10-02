
/**

*/

import java.util.*;
import java.io.*;

class Solution {
    public boolean equalFrequency(String word) {
        int[] freq = new int[26];
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : freq) {
            if (i != 0) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        if (map.size() == 1) {
            if (map.firstEntry().getValue() == 1) {
                return true;
            }else{
                return false;
            }
        }
        TreeSet<Integer> set = new TreeSet<>();
        for(Integer i: map.keySet()){
            set.add(i);
        }
        if(set.size()==2){
            if(Math.abs(set.first()-set.last())==1) return true;
            else return false;
        }else if(set.size()==1 && set.first()==1){
            
            return true;
        }else{
            return false;
        }
    }
}

public class cc {
    public static void main(String[] args) throws Exception {
    }
}