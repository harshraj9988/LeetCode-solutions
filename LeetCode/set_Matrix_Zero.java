    // Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

    // You must do it in place.

    

    // Example 1:

    // 1   1   1               1   0   1
    // 1   0   1               0   0   0
    // 1   1   1               1   0   1

    // Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
    // Output: [[1,0,1],[0,0,0],[1,0,1]]
    // Example 2:

    // 0   1   2   0               0   0   0   0
    // 3   4   5   2               0   4   5   0
    // 1   3   1   5               0   3   1   0

    // Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
    // Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
    

    // Constraints:

    // m == matrix.length
    // n == matrix[0].length
    // 1 <= m, n <= 200
    // -231 <= matrix[i][j] <= 231 - 1

public class set_Matrix_Zero {
    public void setZeroes(int[][] ma) {
        int m=ma.length;
        int n=ma[0].length;
        
        int f=-2147483647;
        


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(ma[i][j]==0){ ma[i][j]=f; }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(ma[i][j]==f){
                    for (int k = 0; k < n; k++) {
                        if(ma[i][k]!=f) ma[i][k]=0;
                    }
                    for (int l = 0; l < m; l++) {
                        if(ma[l][j]!=f) ma[l][j]=0;
                    }
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(ma[i][j]==f) ma[i][j]=0;
            }
        }


    }
}
