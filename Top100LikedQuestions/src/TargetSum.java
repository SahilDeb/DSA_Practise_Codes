import java.util.Arrays;

public class TargetSum {

	static int ways;
	static int target;
	static int[][] memo;
	public static int findTargetSum(int[] nums, int currSum, int idx) {
		if (idx == nums.length) {
			if (currSum == target)
				return 1;
			else
				return 0;
		}
		else {
//			The factor of 1000 has been added as an offset to the sum value to map all the sums possible to positive integer range.
			if (memo[idx][currSum + 1000] != Integer.MIN_VALUE)
				return memo[idx][currSum + 1000];
			
			int add = findTargetSum(nums, currSum+nums[idx], idx+1);
			int sub = findTargetSum(nums, currSum-nums[idx], idx+1);
			return memo[idx][currSum + 1000] = add + sub;
		}
	}
	// Recursive with memoization
//	public static int findTargetSumWays(int[] nums, int S) {
//        ways = 0;
//        target = S;
//        memo = new int[nums.length][2000 + S];
//        for (int[] arr: memo) {
//        	Arrays.fill(arr, Integer.MIN_VALUE);
//        }
//        return findTargetSum(nums, 0, 0);
//    }
	
	// DP Solution
	public static int findTargetSumWays(int[] nums, int S) {
//        int[][] dp = new int[nums.length][2001];
//        dp[0][nums[0] + 1000] = 1;
//        dp[0][-nums[0] + 1000] += 1;
//        
//        for (int i = 1; i < nums.length; i++) {
//        	for (int sum = -1000; sum <= 1000; sum++) {
//        		if (dp[i-1][sum+1000] > 0) {
//        			dp[i][sum - nums[i] + 1000] += dp[i-1][sum+1000];
//        			dp[i][sum + nums[i] + 1000] += dp[i-1][sum+1000];
//        		}
//        	}
//        }
//        
//        return S > 1000 ? 0 : dp[nums.length-1][S + 1000];
		
		int[] dp = new int[2001];
		dp[nums[0] + 1000] = 1;
		dp[-nums[0] + 1000] += 1;
		
		for (int i = 1; i < nums.length; i++) {
			int[] next = new int[2001];
			for (int sum = -1000; sum <= 1000; sum++) {
				if (dp[sum + 1000] > 0) {
					next[sum + nums[i] + 1000] += dp[sum+1000];
					next[sum - nums[i] + 1000] += dp[sum+1000];
				}
			}
			dp = next;
		}
		
		return S > 1000 ? 0 : dp[S+1000];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 1, 1, 1};
		int s = 2;
		System.out.println(findTargetSumWays(nums, s));
	}

}
