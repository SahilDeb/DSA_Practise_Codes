import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class RightSideView {

	public static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode() {}
		 TreeNode(int val) { this.val = val; }
	}
	
	public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        
        while (!q.isEmpty()) {
        	TreeNode node = q.poll();
        	if (node != null && q.peek() == null)
        		result.add(node.val);
        	
        	if (node == null) {
        		if (q.peek() == null)
        			break;
        		continue;
        	}
        	
        	if (node.right != null)
        		q.add(node.right);
        	
        	if (node.left != null)
        		q.add(node.left);
        	
        	if (q.peek() == null)
        		q.add(null);
        }
        
        return result;
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,-1,5,-1,4};
		TreeNode root = createTree(arr);
		System.out.println(rightSideView(root));
		
	}

}
