
/**
Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 

Example 1:


Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
Example 2:


Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []
 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] is a lowercase English letter.
1 <= words.length <= 3 * 104
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
All the strings of words are unique.
*/

import java.util.*;
import java.io.*;

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        Trie trie = createTrie(words);
        int[] del = new int[]{-1, 0, 1, 0, -1};
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
               dfs(trie, ans, board, i, j, del, m, n);
            }
        }
        return ans;
    }

    private void dfs(Trie trie, List<String> ans, char[][] board, int i, int j, int[] d, int m, int n) {
        char c = board[i][j];
        if(c=='*' || trie.next[c-'a']==null) return;
        trie = trie.next[c-'a'];
        if(trie.word!=null) {
            ans.add(trie.word);
            trie.word = null;
        }
        board[i][j] = '*';
        for(int dx=0; dx<4; dx++) {
            int x = i+d[dx], y = j+d[dx+1];
            if(x>=0 && x<m && y>=0 && y<n) {
                dfs(trie, ans, board, x, y, d, m, n);
            }
        }
        board[i][j] = c;
    }

    class Trie {
        Trie[] next = new Trie[26];
        String word;
    }

    public Trie createTrie(String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            Trie curr = root;
            for (char c : word.toCharArray()) {
                int x = c - 'a';
                if (curr.next[x] == null)
                    curr.next[x] = new Trie();
                curr = curr.next[x];
            }
            curr.word = word;
        }
        return root;
    }

}