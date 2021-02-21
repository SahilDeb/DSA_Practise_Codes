import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//You are given an array nums of n positive integers.
//You can perform two types of operations on any element of the array any number of times:
//If the element is even, divide it by 2.
//For example, if the array is [1,2,3,4], then you can do this operation on the last element, and the array will be [1,2,3,2].
//If the element is odd, multiply it by 2.
//For example, if the array is [1,2,3,4], then you can do this operation on the first element, and the array will be [2,2,3,4].
//The deviation of the array is the maximum difference between any two elements in the array.
//
//Return the minimum deviation the array can have after performing some number of operations.
public class MinimizeDeviationArray {

	// Approach
	// Multiply all odd numbers by 2, to get positive nums
	// Decrease the largest Even number
	// Store the array elements in sorted order
	// Greedily reduce the max element in the set
	// If max element is ODD, break
	// Return min deviation
	public static int minimumDeviation(int[] nums) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int num: nums) {
			if (num%2 != 0)
				arr.add(2*num);
			else
				arr.add(num);
		}
		
		arr.sort(null);
		
		System.out.println(arr);
		
		int diff = Math.abs(arr.get(arr.size()-1) - arr.get(0));
		
		// If the size > 0 and the last element is even
		while (arr.size() > 0 && arr.get(arr.size()-1)%2 == 0) {
			int maxEl = arr.get(arr.size()-1);
			arr.remove(arr.size()-1);
			arr.add(maxEl/2);
			diff = Math.min(diff, Math.abs(arr.get(arr.size()-1) - arr.get(0)));
		}
		
        return diff;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,8,6,1,6};
		System.out.println(minimumDeviation(arr));
	}

}
