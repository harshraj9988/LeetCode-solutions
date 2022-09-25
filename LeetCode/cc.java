
/**

*/

import java.util.*;

class Solution {

    public String getEncryptedNumber(int[] numbers) {
        int n = numbers.length;
        for(int i=n-1; i>1; i--) {
            for(int j=0; j<i; j++) {
                numbers[j] = (numbers[j]+numbers[j+1])%10;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(numbers[0]);
        sb.append(numbers[1]);
        return sb.toString();
    }

    
    
}

public class cc {
    public static void main(String[] args) {
        int[] numbers = {4,5};
        System.out.println(new Solution().getEncryptedNumber(numbers));
    }
}