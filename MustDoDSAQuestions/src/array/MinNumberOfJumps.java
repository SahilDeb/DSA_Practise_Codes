package array;

public class MinNumberOfJumps {

	public static int minJumps(int[] arr){
		if (arr.length <= 1)
			return 0;
		
		if (arr[0] == 0)
			return -1;
		
        // your code here
		int maxReach = arr[0]; // stores the maximal reachable index in the array.
		int step = arr[0]; // stores the number of steps we can still take(and is initialized with value at index 0, i.e. initial number of steps)
		int jump = 1; // stores the amount of jumps necessary to reach that maximal reachable position.
		
		for (int i = 1; i < arr.length; i++) {
			if (i == arr.length-1)
				return jump;
			
			maxReach = Math.max(maxReach, i + arr[i]);
			step--; // To get the correct index for jump
			if (step == 0) {
				jump++; // we need to jump
				
				if (i >= maxReach)
					return -1;
				
				step = maxReach - i;
			}
		}
		
		return -1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,3,1,1,2,4,2,0,1,1};
		System.out.println(minJumps(arr));

	}

}
