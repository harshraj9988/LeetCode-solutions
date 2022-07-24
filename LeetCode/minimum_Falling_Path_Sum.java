/**
 * Given an n x n array of integers matrix, return the minimum sum of any
 * falling path through matrix.
 * 
 * A falling path starts at any element in the first row and chooses the element
 * in the next row that is either directly below or diagonally left/right.
 * Specifically, the next element from position (row, col) will be (row + 1, col
 * - 1), (row + 1, col), or (row + 1, col + 1).
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * Output: 13
 * Explanation: There are two falling paths with a minimum sum as shown.
 * Example 2:
 * 
 * 
 * Input: matrix = [[-19,57],[-40,-5]]
 * Output: -59
 * Explanation: The falling path with a minimum sum is shown.
 * 
 * 
 * Constraints:
 * 
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 100
 * -100 <= matrix[i][j] <= 100
 */
public class minimum_Falling_Path_Sum {
	public int minFallingPathSum(int[][] matrix) {
		return spaceOptimization(matrix);
	}

	// n = matrix.length -1; i = matrix.length-1; j = 0..matrix.length-1;
	private int solve(int[][] arr, int i, int j, int n) {
		if (i == 0)
			return arr[i][j];

		int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
		if (j > 0) {
			left = solve(arr, i - 1, j - 1, n);
		}
		int curr = solve(arr, i - 1, j, n);
		if (j < n) {
			right = solve(arr, i - 1, j + 1, n);
		}

		int min = Math.min(left, Math.min(curr, right));
		return arr[i][j] + min;
	}

	// dp = new int[n+1][n+1] where dp[i][j] = Integer.MIN_VALUE;
	private int memoization(int[][] arr, int i, int j, int n, int[][] dp) {
		if (i == 0)
			return arr[i][j];

		if (dp[i][j] != Integer.MIN_VALUE)
			return dp[i][j];

		int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
		if (j > 0) {
			left = memoization(arr, i - 1, j - 1, n, dp);
		}
		int curr = memoization(arr, i - 1, j, n, dp);
		if (j < n) {
			right = memoization(arr, i - 1, j + 1, n, dp);
		}

		int min = Math.min(left, Math.min(curr, right));
		return dp[i][j] = arr[i][j] + min;
	}

	private int tabulation(int[][] arr) {
		int n = arr.length;
		int[][] dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			dp[0][i] = arr[0][i];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
				if (j > 0)
					left = dp[i - 1][j - 1];
				if (j < n - 1)
					right = dp[i - 1][j + 1];
				int curr = dp[i - 1][j];
				int min = Math.min(Math.min(left, right), curr);
				dp[i][j] = arr[i][j] + min;
			}
		}
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			int temp = dp[n - 1][i];
			min = Math.min(min, temp);
		}

		return min;
	}

	private int spaceOptimization(int[][] arr) {
		int n = arr.length;
		int[] so = new int[n];

		for (int i = 0; i < n; i++) {
			so[i] = arr[0][i];
		}

		for (int i = 1; i < n; i++) {
			int[] temp = new int[n];
			for (int j = 0; j < n; j++) {
				int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
				if (j > 0)
					left = so[j - 1];
				if (j < n - 1)
					right = so[j + 1];
				int curr = so[j];
				int min = Math.min(Math.min(left, right), curr);
				temp[j] = arr[i][j] + min;
			}
			so = temp;
		}
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			int temp = so[i];
			min = Math.min(min, temp);
		}

		return min;
	}

}
