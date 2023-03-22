
/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
Explanation: There are 2 shortest transformation sequences:
"hit" -> "hot" -> "dot" -> "dog" -> "cog"
"hit" -> "hot" -> "lot" -> "log" -> "cog"
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: []
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

Constraints:

1 <= beginWord.length <= 5
endWord.length == beginWord.length
1 <= wordList.length <= 500
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
The sum of all shortest transformation sequences does not exceed 105.
 */

import java.util.*;

public class word_Ladder_2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int wordSize = beginWord.length();
        List<List<String>> ans = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, List<String>> steps = new HashMap<>();
        queue.add(new Pair(beginWord, 0));
        List<String> ls = new ArrayList<>();
        ls.add(beginWord);
        int seqLen = 0;
        steps.put(0, ls);
        while (!queue.isEmpty()) {
            String original = queue.peek().word;
            int step = queue.poll().step;
            if (original.equals(endWord)) {
                seqLen = step;
                break;
            }
            char[] word = original.toCharArray();
            for (int i = 0; i < wordSize; i++) {
                char x = word[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    word[i] = c;
                    String nextWord = new String(word);
                    int nextStep = step + 1;
                    if (wordSet.contains(nextWord)) {
                        wordSet.remove(nextWord);
                        queue.add(new Pair(nextWord, nextStep));
                        if (steps.containsKey(nextStep)) {
                            steps.get(nextStep).add(nextWord);
                        } else {
                            List<String> temp = new ArrayList<>();
                            temp.add(nextWord);
                            steps.put(nextStep, temp);
                        }
                    }
                }
                word[i] = x;
            }
        }
        List<String> seq = new ArrayList<>();
        seq.add(endWord);
        if (seqLen != 0)
            dfs(seqLen, endWord, steps, seq, ans);
        return ans;
    }

    private void dfs(int i, String word, Map<Integer, List<String>> steps, List<String> seq, List<List<String>> ans) {
        if (i == 0) {
            List<String> temp = new ArrayList<>();
            for (int x = seq.size() - 1; x >= 0; x--) {
                temp.add(seq.get(x));
            }
            ans.add(temp);
            return;
        }

        for (String prev : steps.get(i - 1)) {
            if (diffOne(word, prev)) {
                seq.add(prev);
                dfs(i - 1, prev, steps, seq, ans);
                seq.remove(seq.size() - 1);
            }
        }

    }

    private boolean diffOne(String a, String b) {
        int n = a.length() - 1;
        boolean ok = false;
        for (; n >= 0; n--) {
            if (a.charAt(n) != b.charAt(n)) {
                if (ok)
                    return false;
                else
                    ok = true;
            }
        }
        return ok;
    }

    private class Pair {
        String word;
        int step;
        Pair(String w, int s) {
            word = w;
            step = s;
        }
    }
}
