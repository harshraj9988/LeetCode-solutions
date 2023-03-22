/**
 * Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary. Find the order of characters in the alien language.
Note: Many orders may be possible for a particular test case, thus you may return any valid order and output will be 1 if the order of string returned by the function is correct else 0 denoting incorrect string returned.
 

Example 1:

Input: 
N = 5, K = 4
dict = {"baa","abcd","abca","cab","cad"}
Output:
1
Explanation:
Here order of characters is 
'b', 'd', 'a', 'c' Note that words are sorted 
and in the given language "baa" comes before 
"abcd", therefore 'b' is before 'a' in output.
Similarly we can find other orders.

Your Task:
You don't need to read or print anything. Your task is to complete the function findOrder() which takes  the string array dict[], its size N and the integer K as input parameter and returns a string denoting the order of characters in the alien language.


Expected Time Complexity: O(N * |S| + K) , where |S| denotes maximum length.
Expected Space Compelxity: O(K)


Constraints:
1 ≤ N, M ≤ 300
1 ≤ K ≤ 26
1 ≤ Length of words ≤ 50
 */
import java.util.*;
public class alien_Dictionary {
    public String findOrder(String [] dict, int N, int K)
    {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<K; i++) {
            List<Integer> temp = new ArrayList<>();
            adj.add(temp);
        }
        for(int i=0; i<N-1; i++) {
            charSeq(adj, dict[i], dict[i+1]);
        }
        int[] indegree = new int[K];
        for(int i=0; i<K; i++) {
            for(int it: adj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<K; i++) {
            if(indegree[i]==0) q.add(i);
        }

    
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            Integer ch = q.poll();
            sb.append((char)((int)'a'+ch));
            for(Integer it: adj.get(ch)) {
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }
        return sb.toString();
    }

    private void charSeq(List<List<Integer>> adj, String a, String b) {
        int i=0, j=0;
        while(i<a.length() && j<b.length()){
            int x = a.charAt(i++)-'a';
            int y = b.charAt(j++)-'a';
            if(x!=y) {
                adj.get(x).add(y);
                return;
            }
        }
    }
}
