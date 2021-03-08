import java.util.HashMap;

public class HouseRobberIII {

	public static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode() {}
		 TreeNode(int val) { this.val = val; }
	}
	
	static HashMap<TreeNode, Integer> rob = new HashMap<TreeNode, Integer>();
	static HashMap<TreeNode, Integer> notRob = new HashMap<TreeNode, Integer>();
	public static int helper(TreeNode node, boolean isParentRobbed) {
        if (node == null)
            return 0;
        
        if (isParentRobbed) {
        	if (rob.containsKey(node)) {
        		return rob.get(node);
        	}
        	
        	int res = helper(node.left, false) + helper(node.right, false);
        	rob.put(node, res);
        	return res;
        }
        else {
        	if (notRob.containsKey(node)) {
        		return notRob.get(node);
        	}
        	
        	int robRes = node.val + helper(node.left, true) + helper(node.right, true);
        	int notRobRes = helper(node.left, false) + helper(node.right, false);
        	
        	int max = Math.max(robRes, notRobRes);
        	notRob.put(node, max);
        	return max;
        }
    }
    
    public static int rob(TreeNode root) {
        int ans = helper(root, false);
        return ans;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
