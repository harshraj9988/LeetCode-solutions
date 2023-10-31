/**
 * You are given an array of strings products and a string searchWord.

Design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.

Return a list of lists of the suggested products after each character of searchWord is typed.

 

Example 1:

Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
Output: [
["mobile","moneypot","monitor"],
["mobile","moneypot","monitor"],
["mouse","mousepad"],
["mouse","mousepad"],
["mouse","mousepad"]
]
Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
Example 2:

Input: products = ["havana"], searchWord = "havana"
Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
Example 3:

Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
 

Constraints:

1 <= products.length <= 1000
1 <= products[i].length <= 3000
1 <= sum(products[i].length) <= 2 * 104
All the strings of products are unique.
products[i] consists of lowercase English letters.
1 <= searchWord.length <= 1000
searchWord consists of lowercase English letters.
 */
import java.util.*;
public class search_Suggestions_System{
    private TrieNode root = new TrieNode('*');

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode(c));
            }
            curr = curr.children.get(c);
            curr.addToPriorityQueue(word);
        }
    }

    class TrieNode {
        public char c;
        public boolean isWord;
        public HashMap<Character, TrieNode> children;
        public PriorityQueue<String> minProds;

        public TrieNode(char c) {
            this.c = c;
            isWord = false;
            children = new HashMap<>();
            minProds = new PriorityQueue<>((a,b)-> b.compareTo(a));
        }

        public void addToPriorityQueue(String word){
            minProds.add(word);
            if(minProds.size()>3){
                minProds.poll();
            }
        }

        public List<String> threeMinProds(){
            List<String> threeMinProdsList = new ArrayList<>();
            while(!minProds.isEmpty()){
                threeMinProdsList.add(minProds.poll());
            }
            Collections.reverse(threeMinProdsList);
            return threeMinProdsList;
        }

    }
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        for (String word : products) {
            insert(word);
        }

        List<List<String>> finalList = new ArrayList<>();

        for(char c: searchWord.toCharArray()){

            if((root = root.children.get(c))==null){
                break;
            }
            finalList.add(root.threeMinProds());
        }

        while(finalList.size()<searchWord.length()){
            finalList.add(new ArrayList<>());
        }

        return finalList;
    }
}