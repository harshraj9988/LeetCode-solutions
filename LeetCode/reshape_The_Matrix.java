

// In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.

    // You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.

    // The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.

    // If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

    

    // Example 1:
    //      1   2       --->        1   2   3   4
    //      3   4       

    // Input: mat = [[1,2],[3,4]], r = 1, c = 4
    // Output: [[1,2,3,4]]
    
    
    // Example 2:
    //          1   2      --->         1   2
    //          3   4                   3   4

    // Input: mat = [[1,2],[3,4]], r = 2, c = 4
    // Output: [[1,2],[3,4]]
    

    // Constraints:

    // m == mat.length
    // n == mat[i].length
    // 1 <= m, n <= 100
    // -1000 <= mat[i][j] <= 1000
    // 1 <= r, c <= 300

public class reshape_The_Matrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m= mat.length;
        int n=mat[0].length;
       
        if((m*n)!=(r*c)) return mat;
        else if(r==m && c==n) return mat;
        else{
            int[][] result=new int[r][c];

            int i=0;
            int j=0;
            for(int a=0;a<r;a++){
                for (int b = 0; b < c; b++) {
                    if(j==n){i++;j=0;}
                    result[a][b]=mat[i][j++];
                }
            }
            return result;
        }
        
    }
}
