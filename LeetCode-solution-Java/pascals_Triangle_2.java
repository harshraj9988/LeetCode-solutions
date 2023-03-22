/**
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the
 * Pascal's triangle.
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it as shown:
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 * Example 2:
 * 
 * Input: rowIndex = 0
 * Output: [1]
 * Example 3:
 * 
 * Input: rowIndex = 1
 * Output: [1,1]
 * 
 * 
 * Constraints:
 * 
 * 0 <= rowIndex <= 33
 * 
 */
import java.util.*;;
public class pascals_Triangle_2 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> ans = new ArrayList<>();

        int n = rowIndex + 1;

        for (int i = 0; i < n; i++) {

            ArrayList<Integer> a = new ArrayList<>();

            for (int j = 0; j <= i; j++) {

                if (j == 0 || j == i)
                    a.add(1);

                else {

                    int x, y, z;

                    x = result.get(i - 1).get(j);

                    y = result.get(i - 1).get(j - 1);

                    z = x + y;

                    a.add(z);

                }

            }

            result.add(a);
            ans = a;

        }

        return ans;
    }
}
