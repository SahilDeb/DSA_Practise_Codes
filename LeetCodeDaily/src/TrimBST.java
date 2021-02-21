
public class TrimBST {

	static class TreeNode 
	{ 
	    int val; 
	    TreeNode left; 
	    TreeNode right; 
	}
	
	public static TreeNode newNode(int num)  
    { 
		TreeNode temp = new TreeNode(); 
        temp.val = num; 
        temp.left = null; 
        temp.right = null; 
        return temp; 
    } 
  
    public static TreeNode insert(TreeNode root, 
                              int key)  
    { 
        if(root == null)  
        { 
            return newNode(key); 
        } 
        if(root.val > key)  
        { 
            root.left = insert(root.left, key); 
        } 
        else 
        { 
            root.right = insert(root.right, key); 
        } 
        return root; 
    } 
      
    private static void inorderTraversal(TreeNode root) 
    { 
        if(root != null)  
        { 
            inorderTraversal(root.left); 
            System.out.print(root.val + " "); 
            inorderTraversal(root.right); 
        } 
    }
	
	public static TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)
            return null;
        
        // Work in Postorder fashion 
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        
        // Fix the root
        if (root.val < low) {
            TreeNode rChild = root.right;
            root = null;
            return rChild;
        }
        
        if (root.val > high) {
            TreeNode lChild = root.left;
            root = null;
            return lChild;
        }
            
        return root;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = null; 
        root = insert(root, 6); 
        root = insert(root, -13); 
        root = insert(root, 14); 
        root = insert(root, -8); 
        root = insert(root, 15); 
        root = insert(root, 13); 
        root = insert(root, 7); 
          
        System.out.print("Inorder Traversal of the given tree is: ");
        
        inorderTraversal(root);
        
        root = trimBST(root, -10, 13);
          
        System.out.print("\nInorder traversal of the modified tree: "); 
        inorderTraversal(root);
	}

}
