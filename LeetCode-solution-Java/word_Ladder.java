
/**
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

Constraints:

1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
*/

import java.util.*;

class Solution {
    // public int ladderLength(String beginWord, String endWord, List<String>
    // wordList) {
    // List<List<Integer>> adj = new ArrayList<>();
    // int n = wordList.size() + 1;
    // List<String> words = new ArrayList<>();
    // words.add(beginWord);
    // for (String word : wordList)
    // words.add(word);
    // int wordSize = beginWord.length();
    // int src = 0;
    // int dest = 0;
    // boolean flag = true;
    // for (int i = 0; i < n; i++) {
    // if (endWord.equals(words.get(i))) {
    // flag = false;
    // dest = i;
    // }
    // List<Integer> temp = new ArrayList<>();
    // for (int j = 0; j < n; j++) {
    // if (i == j)
    // continue;
    // int difference = diff(words.get(i), words.get(j), wordSize);
    // if (difference <= 1)
    // temp.add(j);
    // }
    // adj.add(temp);
    // }
    // if (flag)
    // return 0;

    // // printAdj(adj);

    // int[] dist = new int[n];
    // Arrays.fill(dist, Integer.MAX_VALUE);
    // dist[src] = 0;

    // Queue<Integer> q = new LinkedList<>();
    // q.add(src);

    // while (!q.isEmpty()) {
    // int node = q.poll();
    // for(Integer next: adj.get(node)){
    // if((dist[node]+1)<dist[next]){
    // dist[next] = dist[node]+1;
    // q.add(next);
    // }
    // }
    // }
    // if(dist[dest]==Integer.MAX_VALUE) return 0;
    // return dist[dest]+1;
    // }

    // private int diff(String a, String b, int n) {
    // int cnt = 0;
    // n--;
    // while (n >= 0) {
    // if (a.charAt(n) != b.charAt(n))
    // cnt++;
    // n--;
    // }
    // return cnt;
    // }

    // private void printAdj(List<List<Integer>> adj) {
    // for (List<Integer> list : adj) {
    // System.out.print("[ ");
    // for (Integer pair : list) {
    // System.out.print(pair + " ,");
    // }
    // System.out.print("], ");
    // }
    // }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        while (!q.isEmpty()) {
            String original = q.peek().node;
            if (original.equals(endWord))
                return q.peek().distance;
            char[] word = original.toCharArray();
            int dist = q.poll().distance;
            for (int i = 0; i < word.length; i++) {
                char x = word[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    word[i] = ch;
                    String next = new String(word);
                    if (wordSet.contains(next)) {
                        q.add(new Pair(next, dist + 1));
                        wordSet.remove(next);
                    }

                }
                word[i] = x;
            }
        }

        return 0;
    }

    private class Pair {
        String node;
        int distance;

        Pair(String node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}