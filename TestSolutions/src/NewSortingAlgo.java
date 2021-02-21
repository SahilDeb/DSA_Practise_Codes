import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

//Given a string s. You should re-order the string using the following algorithm:
//Pick the smallest character from s and append it to the result.
//Pick the smallest character from s which is greater than the last appended character to the result and append it.
//Repeat step 2 until you cannot pick more characters.
//Pick the largest character from s and append it to the result.
//Pick the largest character from s which is smaller than the last appended character to the result and append it.
//Repeat step 5 until you cannot pick more characters.
//Repeat the steps from 1 to 6 until you pick all characters from s.
//In each step, If the smallest or the largest character appears more than once you can choose any occurrence and append it to the result.
//
//Input Format
//The first line contains a single integer n — the length of the string.
//The second line contains the string s (string consist only of lowercase English letters).
//
//Constraints
//1 <= n <= 1000
//
//Output Format
//Print resultant string.
//
//Sample Input 0
//3
//rat
//Sample Output 0
//art
public class NewSortingAlgo {

	public static void sortingAlgo(String s) {
		HashMap<Character, Integer> charFreq = new HashMap<Character, Integer>();
		
		for (char ch: s.toCharArray()) {
			if (!charFreq.containsKey(ch))
				charFreq.put(ch, 1);
			else
				charFreq.put(ch, charFreq.get(ch) + 1);
		}
		
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "acsdsd";
		System.out.println((char)(97));
		System.out.println('a' > 'b');
	}

}
