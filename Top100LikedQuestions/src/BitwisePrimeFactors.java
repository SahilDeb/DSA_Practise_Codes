import java.util.ArrayList;
import java.util.HashSet;

public class BitwisePrimeFactors {

	static String bits = "";
	public static ArrayList<Integer> uniquePrimeFactors(int n) {
		HashSet<Integer> primes = new HashSet<Integer>();
		
		String res = "0";
		while (n%2 == 0) {
			n /= 2;
			bits = "";
			bitwiseRepr(2);
			
			// Padding
			while (res.length() < bits.length()) {
				res = "0" + res;
			}
			
			String temp = "";
			for (int i = 0; i < bits.length(); i++) {
				temp += (Integer.parseInt(res.charAt(i)+"") ^ Integer.parseInt(bits.charAt(i)+""));
			}
		}
		
		for (int i = 3; i <= Math.sqrt(n); i++) {
			while (n%i == 0) {
				n /= i;
				primes.add(i);
			}
		}
		
		if (n > 2)
			primes.add(n);
		
		return new ArrayList<Integer>(primes);
	}
	
	// Recursive
	
	public static void bitwiseRepr(long n) {
		// step 1: Check n > 0
		if (n > 1)
			bitwiseRepr(n >> 1);
		
		bits += (n & 1) + "";
	}
	
	public static void bitwisePrimeFactors(long n) {
		String res = "0";
		while (n%2 == 0) {
			n /= 2;
			bits = "";
			bitwiseRepr(2);
			
			// Padding
			if (res.length() < bits.length()) {
				while (res.length() != bits.length()) {
					res = "0" + res;
				}					
			}
			else {
				while (res.length() != bits.length()) {
					bits = "0" + bits;
				}
			}
			
			String temp = "";
			for (int i = 0; i < bits.length(); i++) {
				temp += (Integer.parseInt(res.charAt(i)+"") ^ Integer.parseInt(bits.charAt(i)+""));
			}
			res = temp;
		}
		
		for (int i = 3; i <= Math.sqrt(n); i++) {
			while (n%i == 0) {
				n /= i;

				bits = "";
				bitwiseRepr(i);
				
				// Padding
				if (res.length() < bits.length()) {
					while (res.length() != bits.length()) {
						res = "0" + res;
					}					
				}
				else {
					while (res.length() != bits.length()) {
						bits = "0" + bits;
					}
				}
				
				String temp = "";
				for (int k = 0; k < bits.length(); k++) {
					temp += (Integer.parseInt(res.charAt(k)+"") ^ Integer.parseInt(bits.charAt(k)+""));
				}
				res = temp;
			}
		}
		
		if (n > 2) {
			bits = "";
			bitwiseRepr(n);
			
			// Padding
			if (res.length() < bits.length()) {
				while (res.length() != bits.length()) {
					res = "0" + res;
				}					
			}
			else {
				while (res.length() != bits.length()) {
					bits = "0" + bits;
				}
			}
			
			String temp = "";
			for (int i = 0; i < bits.length(); i++) {
				temp += (Integer.parseInt(res.charAt(i)+"") ^ Integer.parseInt(bits.charAt(i)+""));
			}
			res = temp;
		}
		
		System.out.println(res);
		System.out.println(Long.parseLong(res, 2));
	}
	
	public static void main(String[] args) {
		long n = 674451827;
		bitwisePrimeFactors(n);
	}
}
