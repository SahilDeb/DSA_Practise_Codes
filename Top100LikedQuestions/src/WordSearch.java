import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSearch {
	static boolean[][] visited;
	static char[][] matrix;
//	public static void existUtil(int x, int y, int idx, char[][] board, String word) {
//		if (x >= board.length || y >= board[0].length || x < 0 || y < 0)
//			return;
//		
//		if (board[x][y] != word.charAt(idx) || dp[x][y] == 1)
//			return;
//		
//		if (idx == word.length()-1 && word.charAt(idx) == board[x][y]) {
//			result = true;
//			return;
//		}
//		
//		dp[x][y] = 1;
//		existUtil(x+1, y, idx+1, board, word);
//		existUtil(x-1, y, idx+1, board, word);
//		existUtil(x, y+1, idx+1, board, word);
//		existUtil(x, y-1, idx+1, board, word);
//		dp[x][y] = 0;
//	}
//	
//	public static boolean exist(char[][] board, String word) {
//        ArrayList<ArrayList<Integer>> startingPos = new ArrayList<ArrayList<Integer>>();
//        dp = new int[board.length][board[0].length];
//        for (int i = 0; i < board.length; i++) {
//        	for (int j = 0; j < board[i].length; j++) {
//        		if (board[i][j] == word.charAt(0))
//        			startingPos.add(new ArrayList<>(Arrays.asList(i, j)));
//        	}
//        }
//        
//        System.out.println(startingPos);
//        
//        for (List<Integer> pos: startingPos) {
//        	existUtil(pos.get(0), pos.get(1), 0, board, word);
//        	if (result)
//        		return true;
//        }
//        
//        return false;
//        
//    }
	
	public static boolean dfs(int currRow, int currCol, int idx, String word) {
		// base
		if (idx == word.length())
			return true;
		
		if (currRow >= matrix.length || currCol >= matrix[0].length || currRow < 0 || currCol < 0)
			return false;
		
		if (matrix[currRow][currCol] != word.charAt(idx) || visited[currRow][currCol])
			return false;		
		
		visited[currRow][currCol] = true;
		// dfs for all 4 directions
		boolean top = dfs(currRow-1, currCol, idx+1, word);
		boolean down = dfs(currRow+1, currCol, idx+1, word);
		boolean left = dfs(currRow, currCol-1, idx+1, word);
		boolean right = dfs(currRow, currCol+1, idx+1, word);
		
		boolean ans = top || down || left || right;
		if (ans == false)
			visited[currRow][currCol] = false;
		// return answer
		return ans;
		
	}
	
	public static boolean exist(char[][] board, String word) {
		int rowLen = board.length;
		int colLen = board[0].length;
		matrix = board;
		
		for (int row = 0; row < rowLen; row++) {
			for (int col = 0; col < colLen; col++) {
				if (matrix[row][col] == word.charAt(0)) {
					visited = new boolean[rowLen][colLen];
					boolean res = dfs(row, col, 0, word);
					if (res) return true;
				}
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board ={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCB";
		System.out.println(exist(board, word));

	}

}
