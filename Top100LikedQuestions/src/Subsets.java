import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Subsets {
	static List<List<Integer>> result;
	static int n, k;
	public static void backtrack(int idx, List<Integer> curr, int[] nums) {
		if (curr.size() == k) {
			result.add(new ArrayList<>(curr));
			return;
		}
		
		for (int i = idx; i < n; i++) {
			curr.add(nums[i]);
			backtrack(i+1, curr, nums);
			curr.remove(curr.size()-1);
		}
	}
	
	public static List<List<Integer>> subsets(int[] nums) { 
		// Intuition - O(N * 2^N)
//		HashSet<List<Integer>> result = new HashSet<List<Integer>>();
//		
//		result.add(new ArrayList<>()); // Add the empty array
//		
//		for (int num: nums) {
//			List<List<Integer>> temp = new ArrayList<List<Integer>>();
//			for (List<Integer> curr: result) {
//				temp.add(new ArrayList<Integer>(curr) {{add(num); }});
//			}
//			System.out.println(temp);
//			for (List<Integer> curr: temp) {
//				result.add(curr);
//			}
//			System.out.println(result);
//		}
//		
//		return new ArrayList<>(result);
		
		// Backtracking
		result = new ArrayList<List<Integer>>();
		n = nums.length;
		for (k = 0; k <= n; k++) {
			backtrack(0, new ArrayList<Integer>(), nums);
		}
		
		return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
		System.out.println(subsets(nums));
	}

}
