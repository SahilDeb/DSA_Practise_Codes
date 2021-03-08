import java.util.Arrays;

//Given an integer array nums, return the length of the longest strictly increasing subsequence.
//A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements.
//For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
public class LongestIncreasingSubsequence {
	// DP solution
	public static int lengthOfLISDP(int[] nums) {
		// dp[i] represents the length of the LIS possible considering the array elements
		// up to the ith index only, by necessarily including the ith element.
        int[] dp = new int[nums.length + 1];
		dp[0] = 1;
		int maxans = 1;
		
		for (int i = 1; i < nums.length; i++) {
			dp[i] = 1;
			int maxval = 0;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i])
					maxval = Math.max(maxval, dp[j]);
			}
			dp[i] = maxval + 1;
			maxans = Math.max(maxans, dp[i]);
		}
		
		return maxans;
    }
	
	// Most optimized O(n log n)
	// Using Binary Search
	public static int lengthOfLISBS(int[] nums) {
        int[] dp = new int[nums.length + 1];
		int len = 0;
		
		for (int num: nums) {
			int i = Arrays.binarySearch(dp, 0, len, num);
			if (i < 0)
				i = -(i + 1);
			
			dp[i] = num;
			if (i == len)
				len++;
		}
		return len;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10,9,2,5,3,7,101,18};
		System.out.println(lengthOfLISDP(arr));
		System.out.println(lengthOfLISBS(arr));
	}

}
