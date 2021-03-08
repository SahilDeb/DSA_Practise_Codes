
public class DecodeString {

	public static String decode(String s, int[] idx) {
		StringBuilder sb = new StringBuilder();
		int num = 0;
		
		while (idx[0] < s.length()) {
			char ch = s.charAt(idx[0]);
			idx[0]++;
			
			if (Character.isDigit(ch)) {
				num = num * 10 + Integer.parseInt(ch+"");
			}
			else if (ch == '[') {
				String innerStr = decode(s, idx);
				while (num != 0) {
					sb.append(innerStr);
					num--;
				}
			}
			else if (ch == ']')
				break;
			else
				sb.append(ch);
		}
		
		return sb.toString();
	}
	
	public static String decodeString(String s) {
		int[] idx = {0};
		return decode(s, idx);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "3[a2[c]]";
		System.out.println(decodeString(s));

	}

}
