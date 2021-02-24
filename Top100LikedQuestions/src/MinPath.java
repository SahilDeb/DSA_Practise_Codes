
public class MinPath {

	public static void printArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static int minPathSum(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        
        //the first col is the path sum from top to bottom
        for(int i = 1; i < row; i++)
        {
            dp[i][0] = dp[i - 1][0] + grid[i][0]; 
        }
        
        //populate first row with path sum from left to right
        for(int i = 1; i < col; i++)
        {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        printArray(grid);
        
        printArray(dp);
        
        //start from entry (1,1), add the current element in grid to the minimum of
        //the elements to the left and above
        for (int i = 1; i < row; i++) {
        	for (int j = 1; j < col; j++) {
        		dp[i][j] = grid[i][j] + Math.min(dp[i][j-1], dp[i-1][j]);
        	}
        }
        
        printArray(dp);
        
        return dp[row-1][col-1];
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(minPathSum(arr));

	}

}
