package string;

public class LongestSubstringWithAtleastKRepeatingCharacters {

	public static int longestSubstring(String s, int k) {
        return longestSubstringUtil(s, 0, s.length(), k);
    }
    
    public static int longestSubstringUtil(String s, int start, int end, int k) {
        if (end < k)
            return 0;
        
        int[] countMap = new int[26];
        // update the count of each character
        for (int i = start; i < end; i++) {
            countMap[s.charAt(i) - 'a']++;
        }
        
        for (int mid = start; mid < end; mid++) {
            if (countMap[s.charAt(mid) - 'a'] >= k)
                continue;
            
            int midNext = mid+1;
            while (midNext < end && countMap[s.charAt(midNext) - 'a'] < k) {
                midNext++;
            }
            
            return Math.max(longestSubstringUtil(s, 0, mid, k), longestSubstringUtil(s, midNext, end, k));
        }
        
        return (end - start);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestSubstring("ababcabaaadc", 2));
	}

}
