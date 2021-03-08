
public class CountSetBits {

	static int[] num_of_bits = {0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4};
    
    public static int countBitsUtil(int n) {
        int nibble = 0;
        if (n < 16)
        	return num_of_bits[n];
        
        nibble = n & 15;
        
        return num_of_bits[nibble] + countBitsUtil(n >> 4);
    }
    
    public static int[] countBits(int num) {
        int[] res = new int[num+1];
        
        for (int i = 0; i <= num; i++) {
            res[i] = countBitsUtil(i);
        }
        
        return res;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[] res = countBits(n);
		
		for (int num: res) {
			System.out.print(num + " ");
		}
	}

}
