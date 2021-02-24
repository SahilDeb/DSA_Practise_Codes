import java.util.ArrayList;
import java.util.HashMap;

public class ConstructBTFromPreAndInorder {

	public static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode() {}
		 TreeNode(int val) { this.val = val; }
	}
	
	public static TreeNode buildTreeUtil(int[] preorder, int[] inorder, int inorderStart, int inorderEnd, int preOrderStart) {
		if (inorderStart > inorderEnd || preOrderStart < 0)
			return null;
		
		TreeNode node = new TreeNode(preorder[preOrderStart]); // Take the root values from preorder arr
		int i = -1;
		for (i = inorderStart; i <= inorderEnd; i++) {
			if (inorder[i] == node.val)
				break;
		}
		
		node.left = buildTreeUtil(preorder, inorder, inorderStart, i-1, preOrderStart+1);
		// Skip the number of roots from the left subtree to get index for right subtree
		node.right = buildTreeUtil(preorder, inorder, i+1, inorderEnd, preOrderStart + 1 + (i - inorderStart));
		
		return node;
	}
	
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeUtil(preorder, inorder, 0, inorder.length-1, 0);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preorder = {1, 2, 3};
		int[] inorder = {2, 3, 1};
		
		buildTree(preorder, inorder);
	}

}
