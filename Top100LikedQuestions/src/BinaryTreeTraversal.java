import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversal {

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
	
	static List<Integer> result;
	public static void inorder(TreeNode root) {
        if (root == null)
        	return;
        
        inorder(root.left);
        result.add(root.val);
        inorder(root.right);
    }

	public static List<Integer> inorderTraversal(TreeNode root) {
        result = new ArrayList<Integer>();
        inorder(root);
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,5,3,4,-1,6};
		TreeNode root = createTree(arr);
		System.out.println(inorderTraversal(root));

	}

}
