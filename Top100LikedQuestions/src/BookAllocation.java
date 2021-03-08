import java.util.Arrays;

//Given number of pages in n different books and m students.
//The books are arranged in ascending order of number of pages.
//Every student is assigned to read some consecutive books.
//The task is to assign books in such a way that the maximum number of pages assigned to a student is minimum.
public class BookAllocation {

	public static boolean isPossible(int[] arr, int m, int currPages) {
		int students = 1;
		int currSum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			// check if current number of pages are greater 
            // than currPages that means we will get the result 
            // after mid no. of pages
			if (arr[i] > currPages)
				return false;
			
			// count how many students are required 
            // to distribute currPages pages 
			if (currSum + arr[i] > currPages) {
				// increment student count 
				students++;
				
				// update curr_sum
				currSum = arr[i];
				
				// if students required becomes greater 
                // than given no. of students,return false
				if (students > m) {
					return false;
				}
			}
			// else update curr_sum 
			else {
				currSum += arr[i];
			}
		}
		
		return true;
	}
	
	public static int findPages(int[] arr, int m) {		
		// If the books are less than students
		if (arr.length < m) return -1;
		
		int start = Integer.MIN_VALUE;
		int totalPages = 0;
		for (int num: arr) {
			start = Math.max(start, num);
			totalPages += num;
		}
		
		// Applying Binary Search in this range of max to totalPages
		int end = totalPages;
		int res = Integer.MAX_VALUE;
		
		while (start <= end) {
			int midPages = (start + end)/2;
			if (isPossible(arr, m, midPages)) {
				res = Math.min(res, midPages);
				
				// Try to check for the min number of pages
				end = midPages - 1;
			}
			else {
				// if not possible that means pages need to increased
				start = midPages + 1;
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {12, 67, 37, 90};
		int m = 3;
		
		System.out.println(findPages(arr, m));

	}

}
