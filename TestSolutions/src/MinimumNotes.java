import java.util.Arrays;

public class MinimumNotes {

    public static int minBills(int amount, int[] denominations, int[] memo) {
        if (amount == 0)
            return 0;
        
        if (memo[amount] != 0)
        	return memo[amount];
        
        int minBills = Integer.MAX_VALUE;
        for (int i = denominations.length - 1; i >= 0; i--) {
        	if (denominations[i] <= amount) {
        		int rest = amount - denominations[i]; 
        		int billsCount = minBills(rest, denominations, memo);
        		if (billsCount >= 0 && billsCount < minBills) {
        			minBills = billsCount + 1;
        			return memo[amount] = minBills;
        		}
        	}
        }
        return -1;
    }
    public static int minBills(int amount) {
        int[] denominations = {1, 5, 10, 20, 100};
        int[] memo = new int[amount+1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;
//        int minBillsCount = minBills(amount, denominations, memo);
        
        for (int amt = 1; amt <= amount; amt++) {
        	for (int j = 0; j < denominations.length; j++) {
        		if (denominations[j] <= amt) {
        			memo[amt] = Math.min(memo[amt], memo[amt - denominations[j]] + 1);
        		}
        	}
        }
        return memo[amount];
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int amt = 1000000000;
		System.out.println(minBills(amt));
	}

}
