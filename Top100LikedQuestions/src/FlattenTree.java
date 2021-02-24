import java.util.Stack;

public class FlattenTree {
	
	public static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode() {}
		 TreeNode(int val) { this.val = val; }
	}
	
	public static TreeNode createTree(int[] nodes) {
		TreeNode root = null;
		Stack<TreeNode> st = new Stack<>();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == -1) {
                st.pop();
            } else {
            	TreeNode node = new TreeNode(nodes[i]);
            	
                if (st.size() != 0) {
                    if(st.peek().left == null){
                        st.peek().left = node;
                    }
                    else{
                        st.peek().right = node;
                    }
                } else {
                    root = node;
                }
                st.push(node);
            }
        }
        return root;
	}
	
	public static TreeNode leftLast(TreeNode node) {
		TreeNode temp = node;
		while (temp != null && temp.right != null)
			temp = temp.right;
		
		return temp;
	}
	
	public static TreeNode flattenUtil(TreeNode root) {
		if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        
        
        TreeNode left = flattenUtil(root.left);
        TreeNode right = flattenUtil(root.right);
        
        if (left != null) {
        	TreeNode lastRightNode = leftLast(left);
        	lastRightNode.right = right;
            root.right = left;
            root.left = null;
        }
        
        return root;
    }
	
    public static void flatten(TreeNode root) {
        if (root == null) return;
        flattenUtil(root);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,5,3,4,-1,6};
		TreeNode root = createTree(arr);
	}

}
