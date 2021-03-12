import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.sun.net.httpserver.Authenticator.Result;

public class AnagramsInString {

	static ArrayList<String> anagrams;
	// Get anagrams for a string
    public static void getAnagrams(String res, String p) {
        if (p.length() == 0) {
        	anagrams.add(res);
        	return;
        }
        
        boolean[] alpha = new boolean[26];
        for (int i = 0; i < p.length(); i++) {
        	char ch = p.charAt(i);
        	// Take the rest of the string except the ith character
        	String ros = p.substring(0, i) + p.substring(i+1);
        	if (alpha[ch - 'a'] == false)
        		getAnagrams(res + ch, ros);
        	alpha[ch - 'a'] = true;
        }
    }
    
    public static List<Integer> findAnagrams(String s, String p) {
    	List<Integer> res = new ArrayList<Integer>();
    	if (s == null || p == null || p.length() > s.length() || s.length() == 0 || p.length() == 0)
    		return res;
    	
    	int[] pCount = new int[26];
    	int[] sCount = new int[26];
    	
    	for (int i = 0; i < p.length(); i++) {
    		int idx = p.charAt(i) - 'a';
    		pCount[idx] += 1;
    	}
    	
    	for (int right = 0, left = 0; right < s.length(); right++) {
    		char c = s.charAt(right);
    		sCount[c - 'a'] += 1;
    		
    		if (right - left + 1 > p.length()) {
    			char cj = s.charAt(left);
    			left++;
    			sCount[cj - 'a'] -= 1;
    		}
    		
    		if (Arrays.equals(pCount, sCount))
    			res.add(left);
    	}
    	
    	return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cbaebabacd", p = "abc";
		System.out.println(findAnagrams(s, p));
	}

}
