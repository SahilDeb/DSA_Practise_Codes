public class RotateImage {

	public static void printArray(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void rotate(int[][] matrix) {
		int n = matrix.length;

		for (int i = 0; i < n/2 + n%2; i++) {
			for (int j = 0; j < n/2; j++) {
				int tmp = matrix[n-1-j][i];
				matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
				matrix[j][n-1-i] = matrix[i][j];
				matrix[i][j] = tmp;
				
			}
		}
		
		printArray(matrix);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
		printArray(mat);
		rotate(mat);
		

	}

}
