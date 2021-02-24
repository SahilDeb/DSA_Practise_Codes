
public class UniqueBST {

	// Idea: For all possible values of i, consider i as root,
	// then [1….i-1] numbers will fall in the left subtree and [i+1….n] numbers will fall in the right subtree.
	// So, add (i-1)*(n-i) to the answer.
	// The summation of the products will be the answer to the number of unique BST.
	public static int numTrees(int n) {
        int[] M = new int[n+1];
        
        M[0] = 1; // When 0 node
        M[1] = 1; // When 1 node
        
        // Consider each i value as root
        for (int i = 2; i <= n; i++) {
        	// For left subtree
        	for (int j = 1; j <= i; j++) {
        		// j-1 on the left * n-i on the right + M[i]
        		M[i] += (M[j-1] * M[i-j]);
        	}
        }
        
        return M[M.length-1];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		System.out.println(numTrees(n));

	}

}
