
public class CoinChangeCombinations {

	public static int coinChangeCombo(int target, int[] coins) {
		int[] ways = new int[target+1];
		ways[0] = 1;
		
		for (int i = 0; i < coins.length; i++) {
			for (int j = 0; j < ways.length; j++) {
				if (j >= coins[i]) {
					ways[j] += ways[j - coins[i]];
				}
			}
		}
		
		for (int num: ways) {
			System.out.print(num + " ");
		}
		System.out.println();
		
		return ways[target];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {1, 2, 5};
		int target = 11;
		System.out.println(coinChangeCombo(target, coins));

	}

}
