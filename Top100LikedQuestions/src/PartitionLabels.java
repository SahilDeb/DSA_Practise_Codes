import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//A string S of lowercase English letters is given.
//We want to partition this string into as many parts as possible so that each letter appears in at most one part,
//and return a list of integers representing the size of these parts.
public class PartitionLabels {

	public static List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<Integer>();
        
        HashMap<Character, Integer> lastIndexMap = new HashMap<Character, Integer>();
        
        for (int i = 0; i < S.length(); i++) {
        	char ch = S.charAt(i);
        	lastIndexMap.put(ch, i);
        }
        
        System.out.println(lastIndexMap);
        
        int idx = 0;
        while (idx < S.length()) {
        	char anchor = S.charAt(idx);
        	int partitionSize = lastIndexMap.get(anchor);
        	for (int i = 1; i <= partitionSize; i++) {
        		char ch = S.charAt(i);
        		if (ch != anchor) {
        			partitionSize = Math.max(partitionSize, lastIndexMap.get(ch));
        		}
        	}
        	partitionSize += 1;
        	res.add(partitionSize - idx);
        	idx += (partitionSize - idx);
        }
        return res;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ababcbacadefegdehijhklij";
		System.out.println(partitionLabels(s));
	}

}
