public class HouseRobberII {

	public static int robUtil(int[] nums, int start, int end) {
		int[] dp = new int[end - start];
		// dp[i] represents the maximum robbed value collected till house 'i'
		dp[0] = nums[start];
		dp[1] = Math.max(nums[start], nums[start+1]);
		
		for (int i = start+2, j = 2; i < end; i++, j++) {
			dp[j] = Math.max(dp[j-2]+nums[i], dp[j-1]);
		}
		
		return dp[end - start - 1];
	}
	
	public static int rob(int[] nums) {
		int len = nums.length;
		if (len == 0)
			return 0;
		if (len == 1)
			return nums[0];
		if (len == 2)
			return Math.max(nums[0], nums[1]);
		
		// As we include h1, we automatically have to discard the last house (h_len) as they are neighbors.
        // The problem then reduces to normal house robber problem in the subarray [0, len-2];
        // Similarly then we will calculate the max robbed value for subarray [1, len-1],
        // where we exclude the first house and include the last house.
        // In the end we will return the max out of those two values.
		int first_included = robUtil(nums, 0, len-1);
		int last_included = robUtil(nums, 1, len);
		
		return Math.max(first_included, last_included);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,1};
		System.out.println(rob(nums));
	}

}
