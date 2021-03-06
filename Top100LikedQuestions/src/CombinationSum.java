import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
	static List<List<Integer>> combi;
	static int trgt;
	public static void combinationSumUtil(int[] nums, List<Integer> comb, int idx, int sum) {
		if (sum > trgt) return;
		if (sum == trgt) {
			combi.add(new ArrayList<>(comb));
			return;
		}
		
		for (int i = idx; i < nums.length; i++) {
			comb.add(nums[i]);
			combinationSumUtil(nums, comb, i , sum + nums[i]);
			comb.remove(comb.size() - 1);
		}
    }
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		combi = new LinkedList<>();
		trgt = target;
		combinationSumUtil(candidates, new ArrayList<>(), 0, 0);
        return combi;  
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2, 3, 6, 7};
		System.out.println(combinationSum(arr, 7));
	}

}
