/**
 * Given an integer n, return true if it is a power of four. Otherwise, return false.

An integer n is a power of four, if there exists an integer x such that n == 4x.

 

Example 1:

Input: n = 16
Output: true
Example 2:

Input: n = 5
Output: false
Example 3:

Input: n = 1
Output: true
 

Constraints:

-231 <= n <= 231 - 1
 */

public class power_Of_Four {
    private boolean pow(int n , long x){
        if(x==n) return true;
        if(x>n) return false;
        return pow(n, 4*x);
    }
    
    public boolean isPowerOfFour(int n) {
        if(n==0) return false;
        if(n==1) return true;
        
        return pow(n,1);
    }
}
