/**

*/

import java.util.*;
import java.util.Map.Entry;
import java.io.*;

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        TreeMap<Integer, Integer> wins = new TreeMap<>(), losses = new TreeMap<>();
        for(int[] match: matches) {
            wins.put(match[0], wins.getOrDefault(match[0], 0)+1);
            losses.put(match[1], losses.getOrDefault(match[1], 0)+1);
        }
        for(Integer loser: losses.keySet()) {
            if(wins.containsKey(loser)) wins.remove(loser);
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> noLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        for(Integer winner: wins.keySet()){
            noLoss.add(winner);
        }
        for(Entry<Integer, Integer> entry: losses.entrySet()){
            if(entry.getValue()==1) oneLoss.add(entry.getKey());
        }
        
        ans.add(noLoss);
        ans.add(oneLoss);
        return ans;
    }
}