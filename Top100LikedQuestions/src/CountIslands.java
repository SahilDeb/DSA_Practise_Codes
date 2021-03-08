
public class CountIslands {	
	public static void numIslandsUtil(int x, int y, char[][] grid) {
		if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length)
			return;
		
		if (grid[x][y] == '0')
			return;
		
		grid[x][y] = '0'; // Mark as visited
		
		int[][] directions = {{1,0}, {0, 1}, {-1, 0}, {0, -1}};
		
		for (int[] dir: directions) {
			numIslandsUtil(x+dir[0], y+dir[1], grid);
		}
	}
	
	public static int numIslands(char[][] grid) {
		int res = 0;
		if (grid.length == 0) return res;
		
		int rows = grid.length;
		int cols = grid[0].length;
		
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				if (grid[r][c] == '1') {
					numIslandsUtil(r, c, grid);
					res++;
				}
			}
		}
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = {
				{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}
		};
		
		System.out.println(numIslands(grid));
	}

}
