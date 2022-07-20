/**
 * Ninja is planing this ‘N’ days-long training schedule. Each day, he can
 * perform any one of these three activities. (Running, Fighting Practice or
 * Learning New Moves). Each activity has some merit points on each day. As
 * Ninja has to improve all his skills, he can’t do the same activity in two
 * consecutive days. Can you help Ninja find out the maximum merit points Ninja
 * can earn?
 * You are given a 2D array of size N*3 ‘POINTS’ with the points corresponding
 * to each day and activity. Your task is to calculate the maximum number of
 * merit points that Ninja can earn.
 * For Example
 * If the given ‘POINTS’ array is [[1,2,5], [3 ,1 ,1] ,[3,3,3] ],the answer will
 * be 11 as 5 + 3 + 3.
 * Input Format:
 * The first line of the input contains an integer, 'T,’ denoting the number of
 * test cases.
 * 
 * The first line of each test case contains a single integer,' N’, denoting the
 * number of days.
 * 
 * The next ‘N’ lines of each test case have 3 integers corresponding to
 * POINTS[i].
 * Output Format:
 * For each test case, return an integer corresponding to the maximum coins
 * Ninja can collect.
 * Note:
 * You do not need to print anything. It has already been taken care of. Just
 * implement the given function.
 * Constraints:
 * 1 <= T <= 10
 * 1 <= N <= 100000.
 * 1 <= values of POINTS arrays <= 100 .
 * 
 * Time limit: 1 sec
 * Sample Input 1:
 * 2
 * 3
 * 1 2 5
 * 3 1 1
 * 3 3 3
 * 3
 * 10 40 70
 * 20 50 80
 * 30 60 90
 * Sample Output 1:
 * 11
 * 210
 * Explanation Of Sample Input 1:
 * For the first test case,
 * One of the answers can be:
 * On the first day, Ninja will learn new moves and earn 5 merit points.
 * On the second day, Ninja will do running and earn 3 merit points.
 * On the third day, Ninja will do fighting and earn 3 merit points.
 * The total merit point is 11 which is the maximum.
 * Hence, the answer is 11.
 * 
 * For the second test case:
 * One of the answers can be:
 * On the first day, Ninja will learn new moves and earn 70 merit points.
 * On the second day, Ninja will do fighting and earn 50 merit points.
 * On the third day, Ninja will learn new moves and earn 90 merit points.
 * The total merit point is 210 which is the maximum.
 * Hence, the answer is 210.
 * Sample Input 2:
 * 2
 * 3
 * 18 11 19
 * 4 13 7
 * 1 8 13
 * 2
 * 10 50 1
 * 5 100 11
 * Sample Output 2:
 * 45
 * 110
 */
public class ninja_Training {
    public static int ninjaTraining(int days, int points[][]) {

        return solve_with_tabulation_with_space_optimization(days , points);
    }

    private static int solve(int days, int points[][], int i, int dp[][]) {
        if (days == 0) {
            int max = 0;
            for (int j = 0; j < 3; j++) {
                if (j != i) {
                    max = Math.max(max, points[0][j]);
                }
            }
            return max;
        }

        if (dp[days][i] != 0)
            return dp[days][i];

        int max = 0;
        for (int j = 0; j < 3; j++) {
            if (j != i) {
                int point = points[days][j] + solve(days - 1, points, j, dp);
                max = Math.max(max, point);
            }
        }
        return dp[days][i] = max;
    }

    private static int solve_with_tabulation(int days, int points[][]){
        int[][] dp = new int[days][4];
       
        for(int i=0; i<4; i++){
            int temp = 0;
            for(int j=0; j<3; j++){
                if(j!=i){
                    temp = Math.max(temp, points[0][j]);
                }
            }
            dp[0][i] = temp;
        }

        for (int i = 1; i < days; i++) {
            for (int j = 0; j < 4; j++) {
                int temp = 0;
                for (int k = 0; k < 3; k++) {
                    if(k!=j){
                        int x = points[i][k] + dp[i-1][k];
                        temp = Math.max(temp, x );
                    }
                }
                dp[i][j] = temp;
            }
        }
      
        return dp[days-1][3];
    }

    private static int solve_with_tabulation_with_space_optimization(int days, int points[][]){
       
        int[] sp = new int[4];

        for(int i=0; i<4; i++){
            int temp = 0;
            for(int j=0; j<3; j++){
                if(j!=i){
                    temp = Math.max(temp, points[0][j]);
                }
            }
            sp[i] = temp;
        }

        for (int i = 1; i < days; i++) {
            int[] tempArr = new int[4];
            for (int j = 0; j < 4; j++) {
                int temp = 0;
                for (int k = 0; k < 3; k++) {
                    if(k!=j){
                        int x = points[i][k] + sp[k];
                        temp = Math.max(temp, x );
                    }
                }
                tempArr[j] = temp;
            }
            sp = tempArr;
        }
      
        return sp[3];
    }

}
