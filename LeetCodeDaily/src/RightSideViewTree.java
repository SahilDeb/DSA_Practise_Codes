import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class RightSideViewTree {

	static class TreeNode {
        int val;
        TreeNode left, right;
 
        // constructor
        TreeNode(int key)
        {
            this.val = key;
            left = null;
            right = null;
        }
    }
    static TreeNode root;
    static TreeNode temp = root;
    
    static void insert(TreeNode temp, int key)
    {
        if (temp == null) {
            root = new TreeNode(key);
            return;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(temp);
 
        // Do level order traversal until we find
        // an empty place.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();
 
            if (temp.left == null) {
                temp.left = new TreeNode(key);
                break;
            }
            else
                q.add(temp.left);
 
            if (temp.right == null) {
                temp.right = new TreeNode(key);
                break;
            }
            else
                q.add(temp.right);
        }
    }
	
    public List<Integer> rightSideView(TreeNode root) {
    	List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        q.add(root);
        q.add(null);
        temp = root;
        
        while (!q.isEmpty()) {
        	
        }
        
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);

	}

}
