
public class KthMinInBST {

	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode() {}
		 TreeNode(int val) { this.val = val; }
		 TreeNode(int val, TreeNode left, TreeNode right) {
			 this.val = val;
			 this.left = left;
			 this.right = right;
		 }
	}
	
	static int count;
	static int res;
    public static void kthSmallestUtil(TreeNode node, int k) {
        if (node == null || count>= k)
            return;
        
        kthSmallestUtil(node.left, k);
        
        count += 1;
        
        if (count == k)
            res = node.val;
        
        kthSmallestUtil(node.right, k);
        
    }
    public static int kthSmallest(TreeNode root, int k) {
        count = 0;
        res = -1;
        kthSmallestUtil(root, k);
        return (res == -1) ? 0 : res;        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
