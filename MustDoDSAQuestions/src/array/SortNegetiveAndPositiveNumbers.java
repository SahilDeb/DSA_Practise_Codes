package array;

public class SortNegetiveAndPositiveNumbers {

	public static void sort(int[] arr, int n) {
		int start = 0, end = n - 1;
		while (start <= end) {
			if (arr[start] > 0) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
				end--;
			}
			start++;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
		sort(arr, arr.length);
		for(int n: arr) {
			System.out.print(n + " ");
		}
	}
}
