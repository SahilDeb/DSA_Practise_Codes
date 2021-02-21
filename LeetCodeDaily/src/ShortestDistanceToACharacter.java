import java.util.ArrayList;
import java.util.LinkedList;

//Given a string s and a character c that occurs in s, return an array of integers answer where answer.length == s.length and
//answer[i] is the shortest distance from s[i] to the character c in s.
//Input: s = "loveleetcode", c = "e"
//Output: [3,2,1,0,1,0,0,1,2,2,1,0]
public class ShortestDistanceToACharacter {
	public static int[] shortestToChar(String s, char c) {
        ArrayList<Integer> indices = new ArrayList<Integer>();
        
        for (int i = 0; i < s.length(); i++) {
        	if (s.charAt(i) == c)
        		indices.add(i);
        }
        
        int[] answer = new int[s.length()];
        
        System.out.println(indices);
        
        int curr = 0;
        int prev = -1;
        int i = 0;
        while (i < answer.length)
        	if (s.charAt(i) == c) {
        		answer[i] = 0;
        		i++;
        		prev = curr;
        		curr += 1;
        	}
        	else {
        		int last_idx = prev == -1 ? 0 : indices.get(prev);
        		int next_idx = indices.get(curr);
        		
        		if (last_idx != 0) {
        			int mid = (last_idx + next_idx) / 2;
        			while (i <= mid) {
        				answer[i] = Math.abs(last_idx - i);
        				i++;
        			}
        		}
        		
        		while (i <= next_idx) {
        			answer[i] = Math.abs(next_idx - i);
        			i++;
        		}
        }
        
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "loveleetcode";
		char c = 'e';
		int[] ans = shortestToChar(s, c);
		for (int num: ans) {
			System.out.print(num + " ");
		}
		
		ArrayList<Integer> ll = new ArrayList<Integer>();
		
		
	}

}
