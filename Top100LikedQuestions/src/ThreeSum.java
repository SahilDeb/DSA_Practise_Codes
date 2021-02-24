import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {

	public static List<List<Integer>> threeSum(int[] nums) {
		if (nums == null || nums.length < 3) return new ArrayList<>();
        
        int n = nums.length;
        
        Arrays.sort(nums);
        
        HashSet<List<Integer>> result = new HashSet<>();
        
        for (int low = 0; low < n; low++) {
        	int mid = low + 1;
        	int high = n - 1;
        	
        	while (mid < high) {
        		int sum = nums[low] + nums[mid] + nums[high];
        		if (sum == 0) {
        			result.add(new ArrayList<>(Arrays.asList(nums[low], nums[mid], nums[high])));
        			mid++;
        			high--;
        		}
        		else if (sum < 0)
        			mid++;
        		else
        			high--;
        	}
        }
        
        return new ArrayList<>(result);
        
        
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = {-1,0,1,2,-1,-4};
		System.out.println(threeSum(n));

	}

}
