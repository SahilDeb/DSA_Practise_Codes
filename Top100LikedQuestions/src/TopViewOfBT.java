import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopViewOfBT {

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
	
	public static void TopView(TreeNode root) {
		if (root == null) {
			return;
		}
		
		class QObj {
			TreeNode node;
			int hd;
			
			QObj(TreeNode node, int hd) {
				this.node = node;
				this.hd = hd;
			}
		}
		
		Queue<QObj> q = new LinkedList<QObj>();
		q.add(new QObj(root, 0));
		
		Map<Integer, TreeNode> topView = new HashMap<Integer, TreeNode>();
		
		
		Map<Integer, TreeNode> bottomView = new HashMap<Integer, TreeNode>();
		
		while (!q.isEmpty()) {
			QObj temp = q.poll();
			if (!topView.containsKey(temp.hd)) {
				topView.put(temp.hd, temp.node);
			}
			
			bottomView.put(temp.hd, temp.node);
			
			if (temp.node.left != null)
				q.add(new QObj(temp.node.left, temp.hd-1));
			
			if (temp.node.right != null)
				q.add(new QObj(temp.node.right, temp.hd+1));
		}
		
		List<Integer> sortedKeys = new ArrayList<>(topView.keySet());
		Collections.sort(sortedKeys);
		for (int num: sortedKeys) {
			System.out.print(topView.get(num).val + " ");
		}
		System.out.println();
		sortedKeys = new ArrayList<>(bottomView.keySet());
		Collections.sort(sortedKeys);
		
		for (int num: sortedKeys) {
			System.out.print(bottomView.get(num).val + " ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		TreeNode root = new TreeNode();
		root = insertLevelOrder(arr, root, 0);
		TopView(root);
		
		
	}

}
