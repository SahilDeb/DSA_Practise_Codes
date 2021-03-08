import java.util.Arrays;

public class CoinChangeMin {
	public static int coinChangeUtil(int[] coins, int amount, int[] dp) {
		if (amount == 0)
			return 0;
		
		if (amount < 0)
			return -1;
		
		if (dp[amount] != 0)
			return dp[amount];
		
		int min = Integer.MAX_VALUE;
		for (int i = coins.length-1; i >= 0; i--) {
			int res = coinChangeUtil(coins, amount - coins[i], dp);
			if (res >= 0 && res < min) {
				min = 1 + res;
			}
		}
		
		return dp[amount] = (min == Integer.MAX_VALUE) ? -1 : min; 
	}
	public static int coinChange(int[] coins, int amount) {
		Arrays.sort(coins);
		if (amount < 1) return 0;
		int[] dp = new int[amount+1];
		dp[0] = 1;
		return coinChangeUtil(coins, amount, dp);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {1, 2, 5};
		int target = 11;
		System.out.println(coinChange(coins, target));

	}

}
