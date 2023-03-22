    // Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

    // Each row must contain the digits 1-9 without repetition.
    // Each column must contain the digits 1-9 without repetition.
    // Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
    // Note:

    // A Sudoku board (partially filled) could be valid but is not necessarily solvable.
    // Only the filled cells need to be validated according to the mentioned rules.
    

    // Example 1:

    //        5 3 -   - 7 -   - - -               
    //        6 - -   1 9 5   - - -               
    //        - 9 8   - - -   - 6 -               
    //      
    //        8 - -   - 6 -   - - 3               
    //        4 - -   8 - 3   - - 1               
    //        7 - -   - 2 -   - - 6               
    //      
    //        - 6 -   - - -   2 8 -               
    //        - - -   4 1 9   - - 5               
    //        - - -   - 8 -   - 7 9               


    // Input: board = 
    // [["5","3",".",".","7",".",".",".","."]
    // ,["6",".",".","1","9","5",".",".","."]
    // ,[".","9","8",".",".",".",".","6","."]
    // ,["8",".",".",".","6",".",".",".","3"]
    // ,["4",".",".","8",".","3",".",".","1"]
    // ,["7",".",".",".","2",".",".",".","6"]
    // ,[".","6",".",".",".",".","2","8","."]
    // ,[".",".",".","4","1","9",".",".","5"]
    // ,[".",".",".",".","8",".",".","7","9"]]
    // Output: true
    // Example 2:

    // Input: board = 
    // [["8","3",".",".","7",".",".",".","."]
    // ,["6",".",".","1","9","5",".",".","."]
    // ,[".","9","8",".",".",".",".","6","."]
    // ,["8",".",".",".","6",".",".",".","3"]
    // ,["4",".",".","8",".","3",".",".","1"]
    // ,["7",".",".",".","2",".",".",".","6"]
    // ,[".","6",".",".",".",".","2","8","."]
    // ,[".",".",".","4","1","9",".",".","5"]
    // ,[".",".",".",".","8",".",".","7","9"]]
    // Output: false
    // Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
    

    // Constraints:

    // board.length == 9
    // board[i].length == 9
    // board[i][j] is a digit 1-9 or '.'.

public class valid_Sudoku {

    private boolean check(char[][] board){
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if(board[row][col]!='.'){
                    if( isSafe(board, row, col, board[row][col])==false ) return false;
                }
            }
        }
        return true;
    }

    private boolean isSafe(char[][] board, int row, int col, char c){
        for (int i = 0; i < 9; i++) {   
            if( i!=row && board[i][col]==c) 
                return false;
            if( i!= col && board[row][i]==c) 
                return false;
            int a=3*(row/3) + (i/3);
            int b=3*(col/3) + (i%3);
            if( a!=row && b!=col && board[ a ][ b ]==c) 
                return false;
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        return check(board);
    }
}
