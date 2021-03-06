import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class KeypadCombinations {
	static HashMap<Character, ArrayList<Character>> keyMap;
	public static List<String> letterCombinations(String digits) {
		if (digits.length() == 0)
			return new ArrayList<String>();
		
		
		char rem = digits.charAt(0);
		List<String> res =  letterCombinations(digits.substring(1));
        List<Character> temp = keyMap.get(rem);
        
        if (res.size() == 0) {
        	for (char ch: temp) {
        		res.add(ch+"");        		
        	}
        }
        else {
        	List<String> ob = new ArrayList<String>();
        	for (int i = 0; i < res.size(); i++) {
        		for (char ch: temp) {
        			String t = res.get(i);
        			ob.add(ch + t);
        		}
        	}
        	res = ob;
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num = "23";
		keyMap = new HashMap<>();
        keyMap.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        keyMap.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        keyMap.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        keyMap.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        keyMap.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        keyMap.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        keyMap.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        keyMap.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));
		System.out.println(letterCombinations(num));
	}

}
