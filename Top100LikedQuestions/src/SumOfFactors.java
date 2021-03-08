import java.util.ArrayList;
import java.util.HashSet;

public class SumOfFactors {

	public static ArrayList<Integer> findPrimeFactors(int n) {
		ArrayList<Integer> primeFactors = new ArrayList<Integer>(); 
		// Step 1 : Divide the number by 2 until you get an Odd number, and print 2 ( Only even Prime Number )
		while (n%2 == 0) {
			primeFactors.add(2);
			n /= 2;
		}
		
		// Step 2 : Starting from 3 to sqrt(n), if n is divisible by i, print i and divide n by i
		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			while (n%i == 0) {
				primeFactors.add(i);
				n /= i;
			}
		}
		
		// Step 3 : If n is a prime number > 2, then just print n
		if (n > 2)
			primeFactors.add(n);
		
		return primeFactors;
	}
	
	public static int sumOfFactors(int n) {
		// Step 1 : Get all the prime factors for n
		int sum = 1;
		
		for (int i = 2; i <= Math.sqrt(n); i++) {
			int curr_sum = 1;
			int curr_term = 1;
			while (n%i == 0) {
				n /= i;
				curr_term *= i;
				curr_sum += curr_term;
			}
			
			sum *= curr_sum;
		}
		
		if (n > 2)
			sum *= (1 + n);
		
		return sum;
	}
	
	public static int sumOfOddFactors(int n) {
		// Remove the even factors from n
		// then start the calculation
		
		int sum = 1;
		while (n%2 == 0) {
			n /= 2;
		}
		
		for (int i = 3; i <= Math.sqrt(n); i++) {
			int curr_term = 1;
			int curr_sum = 1;
			while (n%i == 0) {
				n /= i;
				curr_term *= i;
				curr_sum += curr_term;
			}
			sum *= curr_sum;
		}
		
		if (n > 2)
			sum *= (1 + n);
		
		return sum;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 30;
		System.out.println(sumOfFactors(n));
		System.out.println(sumOfOddFactors(n));

	}

}
