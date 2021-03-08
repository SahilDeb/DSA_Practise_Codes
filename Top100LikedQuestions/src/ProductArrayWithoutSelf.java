
public class ProductArrayWithoutSelf {

//	public static int[] productExceptSelf(int[] nums) {
//        int n = nums.length;
//        int[] res = new int[n];
//        
//        int[] leftProds = new int[n];
//        leftProds[0] = 1;
//        int[] rightProds = new int[n];
//        rightProds[n-1] = 1;
//        
//        for (int i = 1; i < nums.length; i++) {
//            leftProds[i] = leftProds[i-1]*nums[i-1];
//        }
//        
//        for (int i = n-2; i >= 0; i--) {
//            rightProds[i] = rightProds[i+1]*nums[i+1];
//        }
//        
//        
//        for (int i = 0; i < n; i++) {
//            res[i] = leftProds[i]*rightProds[i];
//        }
//        
//        return res;
//    }
	
	// Space Complexity O(1)
	// Use the result array as left and right
	public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
        	res[i] = res[i-1]*nums[i-1];
        }
        
        // 	R contains the product of all the elements to the right
        // Note: for the element at index 'length - 1', there are no elements to the right,
        // so the R would be 1
        int R = 1;
        
        for (int i = n-1; i >= 0; i--) {
        	res[i] = res[i]*R;
        	R *= nums[i];
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4};
		
		int[] res = productExceptSelf(arr);
	}

}
