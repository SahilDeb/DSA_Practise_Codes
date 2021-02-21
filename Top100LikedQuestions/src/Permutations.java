import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Permutations {

	static List<List<Integer>> result;
	public static void permuteUtil(int[] nums, ArrayList<Integer> comb) {
		if (comb.size() == nums.length) {
			result.add(new ArrayList<>(comb));
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (comb.contains(nums[i])) continue;
			
			comb.add(nums[i]);
			permuteUtil(nums, comb);
			comb.remove(comb.size() - 1);
		}
	}
    public static List<List<Integer>> permute(int[] nums) {
        result = new LinkedList<List<Integer>>();
        permuteUtil(nums, new ArrayList<Integer>());
        return result;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3};
		System.out.println(permute(arr));

	}

}
