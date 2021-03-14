package array;

public class MaxContiguousSubarraySum {

	public static int maxSubarraySum(int arr[], int n){
		int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < n; i++) {
        	currSum += arr[i];
            if (currSum < 0)
                currSum = 0;
            
            maxSum = Math.max(maxSum, currSum);
        }
        
        maxSum = Math.max(maxSum, currSum);
        return maxSum;
	}
        
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {9,-51,-20,-13,-51,40,-21,75,-24,29,-86,5,-38,15,48,-87,-9,42,39,64,47,-63,22,-81,-20,-100,28};
		System.out.println(maxSubarraySum(arr, arr.length));
	}

}
