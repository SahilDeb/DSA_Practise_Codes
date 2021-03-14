import java.util.Arrays;

public class SweetsDistribution {

	public static int sweetDistribution(int[] marks) {      
        Arrays.sort(marks);
        int[] sweets = new int[marks.length];
        Arrays.fill(sweets, 1);
        
        for (int i = 1; i < marks.length; i++) {
        	if (marks[i] > marks[i-1]) {
        		sweets[i] += sweets[i-1];
        	}
        	else {
        		sweets[i] = sweets[i-1];
        	}
        }
        
        int totalSweets = 0;
        for(int n: sweets)
        	totalSweets += n;
        
        return totalSweets;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] m = {1, 5, 2, 2, 6, 1};
		System.out.println(sweetDistribution(m));
	}

}
