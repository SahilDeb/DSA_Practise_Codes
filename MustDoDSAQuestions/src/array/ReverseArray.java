package array;

public class ReverseArray {

	public static void reverse(int[] arr) {
		int n = arr.length;
		int temp;
		for (int i = 0; i < n/2; i++) {
			temp = arr[i];
			arr[i] = arr[n-i-1];
			arr[n-i-1] = temp;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 4, 5, 6};
		reverse(arr);
		for (int val: arr) {
			System.out.print(val + " ");			
		}
	}

}
