import javax.xml.stream.events.StartDocument;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * 
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 45
 */
public class climbing_Stairs {
    private int[] stairs;

    public int climbStairs(int n) {
        stairs = new int[n+1];
        for (int i = 0; i <= n; i++) {
            stairs[i] = -1;
        }
        return fib(n);
    }

    private int solve(int n) {
        if(n<=1) return 1;
        if(stairs[n]!=-1) return stairs[n];

        int left = solve(n-1);
        int right = solve(n-2);

        return stairs[n] = left + right;
    }
    
    private int fib(int n){
        if(n<=1) return 1;
        if(n==2) return 2;
        
        int a = 2;
        int b = 1;
        int count = 0;
        for(int i=2; i<n; i++){
            count = a+b;
            b = a;
            a = count;
        }
        return count;
        
    }
}
