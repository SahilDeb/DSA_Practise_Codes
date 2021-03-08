
public class MaximalMatrix {

	// Time Complexity O(mn)
	public static int maximalSquare(char[][] matrix) {
		int m = matrix.length;
		int n = m > 0 ? matrix[0].length : 0;
		
		int maxLen = Integer.MIN_VALUE;
		
		int[][] dp = new int[m+1][n+1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (matrix[i-1][j-1] == '1') {
					dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
					maxLen = Math.max(maxLen, dp[i][j]);
				}
			}
		}
		
		return maxLen*maxLen;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] m = {{'1','0','1','1','1'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
		System.out.println(maximalSquare(m));

	}

}
