import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//You are climbing a staircase. It takes n steps to reach the top.
//Each time you can either climb 1 or 2 steps. 
//In how many distinct ways can you climb to the top?
public class ClimbingStaircase {
	public static int climbStairs(int n, int[] dp) {
		// Recursive approach - Fibonacci series
//		if (dp.containsKey(n)) return dp.get(n);
//		if (n == 0 || n == 1)
//			return 1;
//		else {
//			int val = climbStairs(n-1) + climbStairs(n-2);
//			dp.put(n, val);
//			return val;
//		}
		
		// Iterative Optimized approach
		// Pattern distinct ways
		dp[0] = 1;
		dp[1] = 1;
		
		// Can be extended for n steps at a time
		for (int stair = 2; stair <= n; stair++) {
			for (int step = 1; step <= 2; step++) {
				dp[stair] += dp[stair-step];
			}
		}
		
		return dp[n];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[] dp = new int[n+5];
		System.out.println(climbStairs(n, dp));		
	}

}
