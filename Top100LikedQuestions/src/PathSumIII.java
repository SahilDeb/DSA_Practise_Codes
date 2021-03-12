import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathSumIII {

	public static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode() {}
		 TreeNode(int val) { this.val = val; }
	}
	
	public static TreeNode insertLevelOrder(int[] arr, TreeNode root, int i) 
	{ 
		// Base case for recursion 
		if (i < arr.length) {
			if (arr[i] == -1)
				return null;
			
			root = new TreeNode(arr[i]);
			// insert left child
			root.left = insertLevelOrder(arr, root.left, 2 * i + 1);
			// insert right child
			root.right = insertLevelOrder(arr, root.right, 2 * i + 2); 
		} 
		return root; 
	} 

	
	static int count = 0;
//	we make use of a hashmap mapmap which is used to store the cumulative sum up to all the indices possible along with the number of times the same sum occurs
    static Map<Integer, Integer> map = new HashMap<>();
	public static void preOrder(TreeNode root, int target, int currSum) {
		if (root == null)
			return;
		
		currSum += root.val;
		
		if (currSum == target)
			count++;
		
		//the map contains the total sum from the root to the current node.
		if (map.containsKey(currSum - target))
			count += map.get(currSum - target);
		
//		Add the prefix sum to the hashmap
		map.put(currSum, map.getOrDefault(currSum, 0)+1);
		
		preOrder(root.left, target, currSum);
		preOrder(root.right, target, currSum);
		
//		Once a path is completely traversed we need to remove that particular prefix sum from the hashmap
		map.put(currSum, map.get(currSum) - 1); // Backtracking
	}
	
	public static int pathSum(TreeNode root, int sum) {
		preOrder(root, sum, 0);
		return count;
	}
	
	public static void inorder(TreeNode root) {
        if (root == null)
        	return;
        
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10, 5, -3, 3, 2, -1, 11, 3, -2, -1, 1};
//		int[] arr = {-2, -1, -3};
		TreeNode root = new TreeNode();
		root = insertLevelOrder(arr, root, 0);
		
		System.out.println(pathSum(root, 8));
	}

}
