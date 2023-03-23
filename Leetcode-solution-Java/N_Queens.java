    // The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

    // Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

    // Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

    

    // Example 1:


    // Input: n = 4
    // Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
    // Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
    // Example 2:

    // Input: n = 1
    // Output: [["Q"]]
    

    // Constraints:

    // 1 <= n <= 9
import java.util.*;
public class N_Queens {

    private void solve(int col, int n, char[][] cell, List<List<String>> result, int[] leftrow, int[] lowerdia, int[] upperdia){
        if(col==n){
            result.add(constructList(cell));
            return;
        }
        for (int row = 0; row < n; row++) {
            if(leftrow[row]==0 && lowerdia[col+row]==0 && upperdia[n-1-row+col]==0){
                cell[row][col]='Q';
                leftrow[row]=1;
                lowerdia[col+row]=1;
                upperdia[n-1-row+col]=1;

                solve(col+1,n,cell,result,leftrow,lowerdia,upperdia);

                cell[row][col]='.';
                leftrow[row]=0;
                lowerdia[col+row]=0;
                upperdia[n-1-row+col]=0;
            }
        }
    }

    private List<String> constructList(char[][] cell){
        List<String> sList= new ArrayList<>();
        for (int i = 0; i < cell.length; i++) {
            String str="";
            for (int j = 0; j < cell.length; j++) {
                str+=cell[i][j];
            }
            sList.add(new String(str));
        }
        return sList;
    }

    public List<List<String>> solveNQueens(int n) {
       List<List<String>> result= new ArrayList<List<String>>();
       char[][] cell=new char[n][n];

       for (int i = 0; i < cell.length; i++) {
           for (int j = 0; j < cell.length; j++) {
               cell[i][j]='.';
           }
       }
       int[] leftrow=new int[n];
       int[] lowerdia=new int[n+n-1];
       int[] upperdia=new int[n+n-1];

       solve(0, n, cell, result, leftrow, lowerdia, upperdia);

       return result;
    }
}
