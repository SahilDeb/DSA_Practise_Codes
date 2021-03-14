import java.util.Arrays;

public class ShortestUnsortedSubarray {

	public static int findUnsortedSubarray(int[] nums) {
		if (nums.length <= 1)
			return 0;
		
        // make a sorted copy of nums
		int[] sorted = nums.clone();
		Arrays.sort(sorted);
		
		// compare each index and find the indices of mismatch from left and right
		int left = nums.length-1, right = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != sorted[i]) {
				left = Math.min(left, i);
				right = Math.max(right, i);				
			}
		}
		
		return (right - left >= 0 ? right - left + 1 : 0);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 2, 2, 3};
		System.out.println(findUnsortedSubarray(nums));
	}

}
