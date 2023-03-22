
/**
A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.

Suppose we need to investigate a mutation from a gene string start to a gene string end where one mutation is defined as one single character changed in the gene string.

For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.

Given the two gene strings start and end and the gene bank bank, return the minimum number of mutations needed to mutate from start to end. If there is no such a mutation, return -1.

Note that the starting point is assumed to be valid, so it might not be included in the bank.

 

Example 1:

Input: start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
Output: 1
Example 2:

Input: start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
Output: 2
Example 3:

Input: start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC","AACCCCCC"]
Output: 3
 

Constraints:

start.length == 8
end.length == 8
0 <= bank.length <= 10
bank[i].length == 8
start, end, and bank[i] consist of only the characters ['A', 'C', 'G', 'T'].
*/

import java.util.*;
import java.io.*;

class Solution {
    char[] mutations = new char[] { 'A', 'C', 'G', 'T' };

    private int dfs(String start, String end, HashMap<String, Integer> map) {
        if (start.equals(end)) {
            return 0;
        }
        if (map.isEmpty()) {
            return 1000;
        }
        char[] st = start.toCharArray();
        int n = st.length;
        int mut = 1000;
        for (int i = 0; i < n; i++) {
            char x = st[i];
            for (char c : mutations) {
                if (x != c) {
                    st[i] = c;
                    String newSt = new String(st);
                    HashMap<String, Integer> newMap = new HashMap<>(map);
                    if (newMap.containsKey(newSt)) {
                        if(newMap.get(newSt)==1) newMap.remove(newSt);
                        else newMap.put(newSt, newMap.get(newSt)-1);
                        mut = Math.min(mut, 1 + dfs(newSt, end, newMap));
                    }
                }
            }
            st[i] = x;
        }
        return mut;
    }

    public int minMutation(String start, String end, String[] bank) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String s: bank) {
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        int ans = dfs(start, end, map);
        return (ans >= 1000) ? -1 : ans;
    }
}