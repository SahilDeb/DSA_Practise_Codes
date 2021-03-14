public class PalindromicSubstring {
	public static void printArray(boolean[][] temp) {
		for (boolean[] t: temp) {
			for (boolean t2: t) {
				System.out.print(t2 + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	// Using DP
//	public static int countSubstrings(String s) {
//		int n = s.length(), ans = 0;
//
//        if (n <= 0) 
//            return 0;
//        
//		boolean[][] dp = new boolean[s.length()][s.length()];
//        
//		// Single letter all palindromes
//		for (int i = 0; i < s.length(); i++, ans++) {
//			dp[i][i] = true;
//		}
//		
//		// Double letter check
//		for (int i = 0; i < n-1; i++) {
//			dp[i][i+1] = s.charAt(i) == s.charAt(i+1);
//			ans += (dp[i][i+1] ? 1 : 0);
//		}
//		
//		// All other substrings of len 3 or more
//		for (int len = 3; len <= n; len++) {
//			// check all substrings of len size till end
//			for (int i = 0, j = i + len - 1; j < n; i++, j++) {
//				System.out.println(s.substring(i, j+1));
//				dp[i][j] = dp[i+1][j-1] && (s.charAt(i) == s.charAt(j));
//				ans += dp[i][j] ? 1 : 0;
//			}
//		}
//		
//		printArray(dp);
//		
//		return ans;
//    }
	
	
	// Expand around centers approach
	public static int countSubstrings(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); ++i) {
            // odd-length palindromes, single character center
            ans += countPalindromesAroundCenter(s, i, i);

            // even-length palindromes, consecutive characters center
            ans += countPalindromesAroundCenter(s, i, i + 1);
        }
        
        return ans;
    }
	
	public static int countPalindromesAroundCenter(String s, int lo, int hi) {
		int ans = 0;
		while (lo >= 0 && hi < s.length()) {
			System.out.println(s.substring(lo, hi+1));
			if (s.charAt(lo) != s.charAt(hi))
				break;
			
			// expand around the center
			lo--;
			hi++;
			ans++;
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "noon";
		System.out.println(countSubstrings(s));
	}

}
