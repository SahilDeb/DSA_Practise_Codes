
public class RotateMatrix {

	public static void rotate(int[][] matrix) {
        int N = matrix.length;
        for (int k = 0; k < N/2; k++) {
        	// First Row
        	int[] temp = new int[N];
        	for (int i = 0; i < N; i++) {
        		temp[i] = matrix[i][N-k-1];
        		matrix[i][N-k-1] = matrix[0][i];
        	}
        	
        	// Last Col
        	
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
		rotate(mat);
	}

}
