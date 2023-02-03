/**
 * You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick. You want to use all the matchsticks to make one square. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.

Return true if you can make this square and false otherwise.

 

Example 1:


Input: matchsticks = [1,1,2,2,2]
Output: true
Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
Example 2:

Input: matchsticks = [3,3,3,3,4]
Output: false
Explanation: You cannot find a way to form a square with all the matchsticks.
 

Constraints:

1 <= matchsticks.length <= 15
1 <= matchsticks[i] <= 108
 */

class MatchSticks_to_Square{

    private boolean solve(int[] matches, int i, int a, int b, int c, int d){
        
        if(i<0) return (a == 0 && b == 0 && c == 0 && d == 0);

        int add = matches[i];
        
        if(add<=a){boolean w = solve(matches, i-1, a-add , b, c, d);
        if(w) return w;}
        if(add<=b){boolean x = solve(matches, i-1, a , b-add, c, d);
        if(x) return x;}
        if(add<=c){boolean y = solve(matches, i-1, a , b, c-add, d);
        if(y) return y;}
        if(add<=d){boolean z = solve(matches, i-1, a , b, c, d-add);
        if(z) return z;}
        
        return false;
    }

    public boolean makesquare(int[] matchsticks) {

        int n = matchsticks.length;
        
        if(n<4) return false;
        
        int p = 0;
        for(int i: matchsticks){
            p+=i;
        }
        if(p%4!=0) return false;
        
        int x = p/4;
        
        return solve(matchsticks, n-1,x,x,x,x);
    }
}
