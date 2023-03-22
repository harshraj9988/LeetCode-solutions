
/**
 *Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100 
 */
import java.util.*;;

public class spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        int a = matrix.length; // vertical length
        int b = matrix[0].length; // horizonal length

        int i = 0;
        int j = 0;

        int x = 1;

        int itemNumber = a * b;
        while (itemNumber > 0) {

            for (; j < b && itemNumber > 0; j++) {
                list.add(matrix[i][j]);
                itemNumber--;
            }
            j--;
            for (i = i + 1; i < a && itemNumber > 0; i++) {
                list.add(matrix[i][j]);
                itemNumber--;
            }
            i--;
            for (j = b - 2; j >= x-1 && itemNumber > 0; j--) {
                list.add(matrix[i][j]);
                itemNumber--;

            }
            j++;
            for (i = a - 2; i >= x && itemNumber > 0; i--) {
                list.add(matrix[i][j]);
                itemNumber--;

            }
            i++;

            x++;
            j++;

            a--;
            b--;

        }

        return list;
    }
}
