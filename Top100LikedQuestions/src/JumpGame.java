
public class JumpGame {
	static int N;
    static boolean res;
    
    public static void canJump(int[] nums, int idx) {
    	idx = 0;
        while (idx <= N) {
        	idx += nums[idx];
        }
    }
    
    public static boolean canJump(int[] nums) {
        int idx = 0;
        N = nums.length - 1;
        res = false;
        canJump(nums, idx);
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5};
		int[] arr = {3,2,1,0,4};
		canJump(arr);

	}

}
