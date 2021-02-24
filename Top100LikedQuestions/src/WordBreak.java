import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

	static Set<String> breakIndexesFails;  
	private static boolean checkWordIsAtTheStart(String str, String word, int wordLen) {
        for (int i = 0; i < wordLen; i++) {
            if (str.charAt(i) != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }
	
    public static boolean wordBreakUtil(String s, List<String> wordDict) {
    	if (s.length() == 0)
    		return true;
    	
    	for (String word: wordDict) {
    		int breakIdx = word.length();
    		if (s.length() >= breakIdx) {
    			if (checkWordIsAtTheStart(s, word, breakIdx)) {
    				String sub = s.substring(breakIdx);
    				if (breakIndexesFails.contains(sub)) continue;
    				
    				if (wordBreakUtil(sub, wordDict))
    					return true;
    				else
    					breakIndexesFails.add(sub);
    			}
    		}
    	}
    	
    	return false;
    	
    	
    }
    
	public static boolean wordBreak(String s, List<String> wordDict) {
//		breakIndexesFails = new HashSet<>();
//        return wordBreakUtil(s, wordDict);
		
		Set<String> set = new HashSet<>();
	    for(String str:wordDict) set.add(str);
	    
        boolean dp[]= new boolean[s.length()+1];
        dp[0]=true;
        for (int i = 1; i <=s.length(); i++) {
            for (int j = i-1; j>=0; j--) {
            	System.out.println(s.substring(j, i));
                if (set.contains(s.substring(j, i))&&dp[j]) {  
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> wordDict = new ArrayList<>(Arrays.asList("aaaa", "aaa"));
		String s = "aaaaaaa";
		
		System.out.println(wordBreak(s, wordDict));

	}

}
