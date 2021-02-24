import java.util.Arrays;

public class JumpGame {
	static int[] memo;
    
	// Top - Down Memomized approach - O(n^2)
	public static boolean canJumpUtil(int idx, int[] nums) {
		if (memo[idx] != -1)
			return memo[idx] == 1 ? true : false;
		
		int furthestJump = Math.min(idx + nums[idx], nums.length-1);
		
		for (int pos = furthestJump; pos > idx; pos--) {
			if (canJumpUtil(pos, nums)) {
				memo[pos] = 1;
				return true;
			}
		}
		
		memo[idx] = 0;
		return false;
	}
	
//    public static boolean canJump(int[] nums) {
//    	int n = nums.length;
//    	// 1 = Good, 0 = Bad, -1 = Unknown
//    	memo = new int[n];
//        Arrays.fill(memo, -1);
//        memo[n-1] = 1; // Last index marked good
////        return canJumpUtil(0, nums);
//        
//        // Bottom-up approach - Start from the end and try to reach idx 0 - O(n^2)
//        for (int pos = n-2; pos >= 0; pos--) {
//        	int furthestJump = Math.min(pos + nums[pos], n-1);
//        	for (int j = pos + 1; j <= furthestJump; j++) {
//        		if (memo[j] == 1) {
//        			memo[pos] = 1;
//        			break;
//        		}
//        	}
//        }
//        
//        return memo[0] == 1;
//    }

    // Greedy approach
    public static boolean canJump(int[] nums) {
    	int n = nums.length;
    	int last_pos = n-1;
    	for (int i = n-1; i >= 0; i--) {
    		if (i + nums[i] >= last_pos) {
    			last_pos = i;
    		}
    	}
    	
    	return last_pos == 0;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5};
		int[] arr = {3,2,1,0,4};
		System.out.println(canJump(arr));

	}

}
