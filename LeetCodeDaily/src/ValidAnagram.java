import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//Given two strings s and t , write a function to determine if t is an anagram of s.
public class ValidAnagram {

	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) return false;
		
//        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
//        HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
//        
//        for (char ch: s.toCharArray()) {
//            if (sMap.containsKey(ch)) {
//                sMap.put(ch, sMap.get(ch) + 1);
//            }
//            else {
//                sMap.put(ch, 1);
//            }
//        }
//        
//        for (char ch: t.toCharArray()) {
//            if (tMap.containsKey(ch)) {
//                tMap.put(ch, tMap.get(ch) + 1);
//            }
//            else {
//                tMap.put(ch, 1);
//            }
//        }
//        
//        System.out.println(sMap + " " + tMap);
//        
//        for (char ch: sMap.keySet()) {
//            if (!tMap.containsKey(ch) || tMap.get(ch) != sMap.get(ch))
//                return false;
//        }
//        return true;
        
		// Count method
		int[] count = new int[256];
	    int i;
	 
	    // For each character in input strings,
	    // increment count in the corresponding count array
	    char[] str1 = s.toCharArray();
	    char[] str2 = t.toCharArray();
	    for(i = 0; i < str1.length; i++) 
	    {
	        count[str1[i] - 'a']++;
	        count[str2[i] - 'a']--;
	    }
	 
	    // See if there is any non-zero 
	    // value in count array
	    for(i = 0; i < 256; i++)
	        if (count[i] != 0)
	            return false;
	    return true;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "";
		String t = "";
		System.out.println(isAnagram(s, t));
	}

}
