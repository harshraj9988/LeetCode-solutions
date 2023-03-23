/**
 * You are given an integer n. We reorder the digits in any order (including the original order) such that the leading digit is not zero.

Return true if and only if we can do this so that the resulting number is a power of two.

 

Example 1:

Input: n = 1
Output: true
Example 2:

Input: n = 10
Output: false
 

Constraints:

1 <= n <= 109
 */
import java.util.*;
public class reordered_Power_Of_2{
    public boolean reorderedPowerOf2(int n) {
        List<Integer> listOfPowers = new ArrayList<>();
        long x = 1;
        while(x<999999999){
            listOfPowers.add((int)x);
            x = x<<1;
        }
        int[] nFreq = findFreq(n);
        boolean isEqual = false;
        for(Integer pow: listOfPowers){
            int[] powFreq = findFreq(pow);
            boolean temp = true;
            for(int i=0; i<10 && temp; i++){
                temp = temp && (nFreq[i]==powFreq[i]);
            }
            isEqual = temp;
            if(isEqual) return true;
        }
        return false;
    }
    
    private int[] findFreq(int n){
        int[] freq = new int[10];
        while(n>0){
            freq[n%10]++;
            n/=10;
        }
        return freq;
    }
}