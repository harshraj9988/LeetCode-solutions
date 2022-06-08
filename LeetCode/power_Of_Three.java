/**
 * Given an integer n, return true if it is a power of three. Otherwise, return false.

An integer n is a power of three, if there exists an integer x such that n == 3x.

 

Example 1:

Input: n = 27
Output: true
Example 2:

Input: n = 0
Output: false
Example 3:

Input: n = 9
Output: true
 

Constraints:

-231 <= n <= 231 - 1
 */

public class power_Of_Three {
    private boolean pow(int n, long x){
        if(x==n) return true;
        if(x>n) return false;
        return pow(n, 3*x);
    }
    
    public boolean isPowerOfThree(int n) {
        if(n==0) return false;
        if(n==1) return true;
        return pow(n,1);
    }
}
