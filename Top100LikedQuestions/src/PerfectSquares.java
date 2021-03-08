import java.util.Arrays;

public class PerfectSquares {

	static int res;
	public static void numSquaresUtil(int target, int[] perfectSq, int count) {
		if (target == 0) {
			res = Math.min(res, count);
			return;
		}
		
		if (target < 0)
			return;
		
		for (int i = perfectSq.length-1; i >= 0; i--) {
			int newTarget = target-perfectSq[i];
			numSquaresUtil(newTarget, perfectSq, count+1);
//			if (res != Integer.MAX_VALUE)
//				return;
		}
			
	}
	
	public static int numSquares(int n) {
		if (n <= 3)
            return n;
		
        int limit = (int)Math.sqrt(n);
        int[] perfectSq = new int[limit];
        
        for (int i = 0; i < limit; i++) {
        	perfectSq[i] = (i+1)*(i+1);
        	System.out.print(perfectSq[i] + " ");
        }
        System.out.println();
        
        int[] dp = new int[n+1];
    	for (int cost = 0; cost <= n; cost++) {
    		dp[cost] = cost;
    		for (int i = 0; i < perfectSq.length; i++) {
    			if (perfectSq[i] <= cost) {
    				dp[cost] = Math.min(dp[cost], dp[cost - perfectSq[i]] + 1);
    				System.out.print(dp[cost] + " ");    				
    			}
        	}
        }
        return dp[n];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 12;
		System.out.println(numSquares(n));
	}

}
