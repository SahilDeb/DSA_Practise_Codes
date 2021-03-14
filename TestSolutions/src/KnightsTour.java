import java.util.LinkedList;
import java.util.Queue;

public class KnightsTour {

	public static boolean isValid(int N, int posX, int posY) {
		if (posX >= 1 && posX <= N && posY >= 1 && posY <= N) 
            return true;
        return false;
	}
	
	static class Cell {
		int x;
		int y;
		int dis;
		Cell(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.dis = d;
		}
	}
	
	public static int minSteps(int N, int sx, int sy, int tx, int ty) {		
		Cell t;
		int x, y;
		int[][] possibleMoves = {{-2, -1},{-1, -2},{1, -2},{2, -1},{-2, 1},{-1, 2},{1, 2},{2, 1}};
		
		Queue<Cell> q = new LinkedList<Cell>();
		q.add(new Cell(sx, sy, 0));
		
		boolean[][] visited = new boolean[N+1][N+1];
		visited[sx][sy] = true;
		
		while (!q.isEmpty()) {
			t = q.poll();
			
			if (t.x == tx && t.y == ty)
				return t.dis;
			
			for (int i = 0; i < 8; i++) {
				x = t.x + possibleMoves[i][0];
				y = t.y + possibleMoves[i][1];
				if (isValid(N, x, y) && !visited[x][y]) {
					visited[x][y] = true;
					q.add(new Cell(x, y, t.dis+1));
				}
			}
		}
		
		return Integer.MAX_VALUE;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 6;
		int sx = 2, sy = 2;
		int tx = 2, ty = 2;
		
		System.out.println(minSteps(N, sx, sy, tx, ty));

	}

}
